    /**
     * Method that copy an existing file system object.
     *
     * @param ctx The current context
     * @param operation Indicates the operation to do
     * @param files The list of source/destination files to copy
     * @param onSelectionListener The listener for obtain selection information (required)
     * @param onRequestRefreshListener The listener for request a refresh (optional)
     */
    private static void copyOrMoveFileSystemObjects(
            final Context ctx,
            final COPY_MOVE_OPERATION operation,
            final List<LinkedResource> files,
            final OnSelectionListener onSelectionListener,
            final OnRequestRefreshListener onRequestRefreshListener) {

        // Some previous checks prior to execute
        // 1.- Listener couldn't be null
        if (onSelectionListener == null) {
            AlertDialog dialog =
                    DialogHelper.createErrorDialog(ctx,
                            R.string.error_title,
                            R.string.msgs_illegal_argument);
            DialogHelper.delegateDialogShow(ctx, dialog);
            return;
        }
        // 2.- All the destination files must have the same parent and it must be currentDirectory,
        // and not be null
        final String currentDirectory = onSelectionListener.onRequestCurrentDir();
        int cc = files.size();
        for (int i = 0; i < cc; i++) {
            LinkedResource linkedRes = files.get(i);
            if (linkedRes.mSrc == null || linkedRes.mDst == null) {
                AlertDialog dialog =
                        DialogHelper.createErrorDialog(ctx,
                                R.string.error_title,
                                R.string.msgs_illegal_argument);
                DialogHelper.delegateDialogShow(ctx, dialog);
                return;
            }
            if (linkedRes.mDst.getParent() == null ||
                linkedRes.mDst.getParent().compareTo(currentDirectory) != 0) {
                AlertDialog dialog =
                        DialogHelper.createErrorDialog(ctx,
                                R.string.error_title,
                                R.string.msgs_illegal_argument);
                DialogHelper.delegateDialogShow(ctx, dialog);
                return;
            }
        }
        // 3.- Check the operation consistency
        if (operation.equals(COPY_MOVE_OPERATION.MOVE)
                || operation.equals(COPY_MOVE_OPERATION.COPY)) {
            if (!checkCopyOrMoveConsistency(ctx, files, currentDirectory, operation)) {
                return;
            }
        }

        // The callable interface
        final BackgroundCallable callable = new BackgroundCallable() {
            // The current items
            private int mCurrent = 0;
            final Context mCtx = ctx;
            final COPY_MOVE_OPERATION mOperation = operation;
            final List<LinkedResource> mFiles = files;
            final OnRequestRefreshListener mOnRequestRefreshListener = onRequestRefreshListener;

            final Object mSync = new Object();
            Throwable mCause;

            @Override
            public int getDialogTitle() {
                return this.mOperation.equals(COPY_MOVE_OPERATION.MOVE)
                        || this.mOperation.equals(COPY_MOVE_OPERATION.RENAME) ?
                        R.string.waiting_dialog_moving_title :
                        R.string.waiting_dialog_copying_title;
            }
            @Override
            public int getDialogIcon() {
                return 0;
            }
            @Override
            public boolean isDialogCancellable() {
                return !(mSrcConsole instanceof SecureConsole)
                        && !(mDstConsole instanceof SecureConsole);
            }

            @Override
            public Spanned requestProgress() {
                File src = this.mFiles.get(this.mCurrent).mSrc;
                File dst = this.mFiles.get(this.mCurrent).mDst;

                // Return the current operation
                String progress =
                      this.mCtx.getResources().
                          getString(
                              this.mOperation.equals(COPY_MOVE_OPERATION.MOVE)
                              || this.mOperation.equals(COPY_MOVE_OPERATION.RENAME) ?
                                  R.string.waiting_dialog_moving_msg :
                                  R.string.waiting_dialog_copying_msg,
                              src.getAbsolutePath(),
                              dst.getAbsolutePath());
                return Html.fromHtml(progress);
            }

            private void refreshUIAfterCompletion() {
                // Remove orphan bookmark paths
                if (files != null) {
                    for (LinkedResource linkedFiles : files) {
                        Bookmarks.deleteOrphanBookmarks(ctx, linkedFiles.mSrc.getAbsolutePath());
                        //Operation complete. Show refresh
                        if (mOnRequestRefreshListener != null) {
                            FileSystemObject fso = null;
                            try {
                                fso = CommandHelper.getFileInfo(ctx,
                                        linkedFiles.mDst.getAbsolutePath(), false, null);
                                mOnRequestRefreshListener.onClearCache(fso);
                            } catch (Exception e) {
                                Log.w(TAG, "Exception getting file info for " +
                                        linkedFiles.mDst.getAbsolutePath(), e);
                            }
                        }
                    }
                }

                if (mOnRequestRefreshListener != null) {
                    mOnRequestRefreshListener.onRequestRefresh(null, true);
                }
            }

            @Override
            public void onSuccess() {
                refreshUIAfterCompletion();
                ActionsPolicy.showOperationSuccessMsg(ctx);
            }

            @Override
            public void doInBackground(Object... params) throws Throwable {
                this.mCause = null;

                // This method expect to receive
                // 1.- BackgroundAsyncTask
                BackgroundAsyncTask task = (BackgroundAsyncTask)params[0];

                int cc2 = this.mFiles.size();
                for (int i = 0; i < cc2; i++) {
                    File src = this.mFiles.get(i).mSrc;
                    File dst = this.mFiles.get(i).mDst;

                    doOperation(this.mCtx, src, dst, this.mOperation);

                    // Next file
                    this.mCurrent++;
                    if (this.mCurrent < this.mFiles.size()) {
                        task.onRequestProgress();
                    }
                }
            }

            @Override
            public void onCancel() {
                if (mSrcConsole != null) {
                    mSrcConsole.onCancel();
                }
                if (mDstConsole != null) {
                    mDstConsole.onCancel();
                }
                if (mOnRequestRefreshListener != null) {
                    mOnRequestRefreshListener.onCancel();
                }
                refreshUIAfterCompletion();
            }

            // Handles required for issuing command death to the consoles
            private Console mSrcConsole;
            private Console mDstConsole;

            /**
             * Method that copy or move the file to another location
             *
             * @param ctx The current context
             * @param src The source file
             * @param dst The destination file
             * @param operation Indicates the operation to do
             */
            private void doOperation(
                    Context ctx, File src, File dst, COPY_MOVE_OPERATION operation)
                    throws Throwable {
                // If the source is the same as destiny then don't do the operation
                if (src.compareTo(dst) == 0) return;

                try {
                    // Be sure to append a / if source is a folder (otherwise system crashes
                    // under using absolute paths) Issue: CYAN-2791
                    String source = src.getAbsolutePath() +
                            (src.isDirectory() ? File.separator : "");
                    String dest = dst.getAbsolutePath() +
                            (dst.isDirectory() ? File.separator : "");

                    /*
                        There is a possibility that the src and dst can have different consoles.
                        A possible case:
                          - src is from sd card and dst is secure storage
                        This could happen with anything that goes from a real console to a virtual
                        console or visa versa.  Here we grab a handle on the console such that we
                        may explicitly kill the actions happening in both consoles.
                     */
                    // Need to derive the console for the source
                    mSrcConsole = CommandHelper.ensureConsoleForFile(ctx, null, source);
                    // Need to derive the console for the destination
                    mDstConsole = CommandHelper.ensureConsoleForFile(ctx, null, dest);

                    // Copy or move?
                    if (operation.equals(COPY_MOVE_OPERATION.MOVE)
                            || operation.equals(COPY_MOVE_OPERATION.RENAME)) {
                        CommandHelper.move(
                                ctx,
                                source,
                                dst.getAbsolutePath(),
                                mSrcConsole);
                    } else {
                        CommandHelper.copy(
                                ctx,
                                source,
                                dst.getAbsolutePath(),
                                mSrcConsole);
                    }
                } catch (Exception e) {
                    // Need to be relaunched?
                    if (e instanceof RelaunchableException) {
                        OnRelaunchCommandResult rl = new OnRelaunchCommandResult() {
                            @Override
                            @SuppressWarnings("unqualified-field-access")
                            public void onSuccess() {
                                synchronized (mSync) {
                                    mSync.notify();
                                }
                            }

                            @Override
                            @SuppressWarnings("unqualified-field-access")
                            public void onFailed(Throwable cause) {
                                mCause = cause;
                                synchronized (mSync) {
                                    mSync.notify();
                                }
                            }
                            @Override
                            @SuppressWarnings("unqualified-field-access")
                            public void onCancelled() {
                                synchronized (mSync) {
                                    mSync.notify();
                                }
                            }
                        };

                        // Translate the exception (and wait for the result)
                        ExceptionUtil.translateException(ctx, e, false, true, rl);
                        synchronized (this.mSync) {
                            this.mSync.wait();
                        }

                        // Persist the exception?
                        if (this.mCause != null) {
                            // The exception must be elevated
                            throw this.mCause;
                        }

                    } else {
                        // The exception must be elevated
                        throw e;
                    }
                }

                // Check that the operation was completed retrieving the fso modified
                FileSystemObject fso =
                        CommandHelper.getFileInfo(ctx, dst.getAbsolutePath(), false, null);
                if (fso == null) {
                    throw new NoSuchFileOrDirectory(dst.getAbsolutePath());
                }
            }
        };
        final BackgroundAsyncTask task = new BackgroundAsyncTask(ctx, callable);

        // Prior to execute, we need to check if some of the files will be overwritten
        List<FileSystemObject> curFiles = onSelectionListener.onRequestCurrentItems();
        if (curFiles != null) {
            // Is necessary to ask the user?
            if (isOverwriteNeeded(files, curFiles)) {
                //Show a dialog asking the user for overwrite the files
                AlertDialog dialog =
                        DialogHelper.createTwoButtonsQuestionDialog(
                                ctx,
                                android.R.string.cancel,
                                R.string.overwrite,
                                R.string.confirm_overwrite,
                                ctx.getString(R.string.msgs_overwrite_files),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface alertDialog, int which) {
                                        // NEGATIVE (overwrite)  POSITIVE (cancel)
                                        if (which == DialogInterface.BUTTON_NEGATIVE) {
                                            // Execute background task
                                            task.execute(task);
                                        }
                                    }
                               });
                DialogHelper.delegateDialogShow(ctx, dialog);
                return;
            }
        }

        // Execute background task
        task.execute(task);
    }

