    /**
     * Method that compresses some uncompressed files or folders
     *
     * @param ctx The current context
     * @param mode The compression mode
     * @param fsos The list of files to compress
     * @param onSelectionListener The listener for obtain selection information (required)
     * @param onRequestRefreshListener The listener for request a refresh (optional)
     * @hide
     */
    static void compress(
            final Context ctx, final CompressionMode mode, final List<FileSystemObject> fsos,
            final OnSelectionListener onSelectionListener,
            final OnRequestRefreshListener onRequestRefreshListener) {

        // The callable interface
        final BackgroundCallable callable = new BackgroundCallable() {
            // The current items
            final Context mCtx = ctx;
            final CompressionMode mMode = mode;
            final List<FileSystemObject> mFsos = fsos;
            final OnRequestRefreshListener mOnRequestRefreshListener = onRequestRefreshListener;

            final Object mSync = new Object();
            Throwable mCause;
            CompressExecutable cmd = null;

            final CompressListener mListener =
                                new CompressListener();
            private String mMsg;
            private boolean mStarted = false;

            @Override
            public int getDialogTitle() {
                return R.string.waiting_dialog_compressing_title;
            }
            @Override
            public int getDialogIcon() {
                return 0;
            }
            @Override
            public boolean isDialogCancellable() {
                return true;
            }

            @Override
            public Spanned requestProgress() {
                // Initializing the dialog
                if (!this.mStarted) {
                    String progress =
                            this.mCtx.getResources().
                                getString(
                                    R.string.waiting_dialog_analizing_msg);
                    return Html.fromHtml(progress);
                }

                // Return the current operation
                String msg = (this.mMsg == null) ? "" : this.mMsg; //$NON-NLS-1$
                String progress =
                      this.mCtx.getResources().
                          getString(
                              R.string.waiting_dialog_compressing_msg,
                              msg);
                return Html.fromHtml(progress);
            }

            @Override
            public void onSuccess() {
                try {
                    if (this.cmd != null && this.cmd.isCancellable() && !this.cmd.isCancelled()) {
                        this.cmd.cancel();
                    }
                } catch (Exception e) {/**NON BLOCK**/}

                //Operation complete. Refresh
                if (this.mOnRequestRefreshListener != null) {
                  // The reference is not the same, so refresh the complete navigation view
                  this.mOnRequestRefreshListener.onRequestRefresh(null, true);
                }
                if (this.cmd != null) {
                    showOperationSuccessMsg(
                            ctx,
                            R.string.msgs_compressing_success,
                            this.cmd.getOutCompressedFile());
                } else {
                    ActionsPolicy.showOperationSuccessMsg(ctx);
                }
            }

            @Override
            public void onCancel() {
                // nop
            }

            @Override
            public void doInBackground(Object... params) throws Throwable {
                this.mCause = null;
                this.mStarted = true;

                // This method expect to receive
                // 1.- BackgroundAsyncTask
                BackgroundAsyncTask task = (BackgroundAsyncTask)params[0];
                String out = null;
                try {
                    // Archive or Archive-Compression
                    if (this.mMode.mArchive) {
                        // Convert the list to an array of full paths
                        String[] src = new String[this.mFsos.size()];
                        int cc = this.mFsos.size();
                        for (int i = 0; i < cc; i++) {
                            src[i] = this.mFsos.get(i).getFullPath();
                        }

                        // Use the current directory name for create the compressed file
                        String curDirName =
                                new File(onSelectionListener.onRequestCurrentDir()).getName();
                        if (src.length == 1) {
                            // But only one file is passed, then used the name of unique file
                            curDirName = FileHelper.getName(this.mFsos.get(0).getName());
                        }
                        String name =
                                String.format(
                                        "%s.%s", curDirName, this.mMode.mExtension); //$NON-NLS-1$
                        String newName =
                                FileHelper.createNonExistingName(
                                        ctx,
                                        onSelectionListener.onRequestCurrentItems(),
                                        name,
                                        R.string.create_new_compress_file_regexp);
                        String newNameAbs =
                                new File(
                                        onSelectionListener.onRequestCurrentDir(),
                                        newName).getAbsolutePath();

                        // Do the compression
                        this.cmd =
                           CommandHelper.compress(
                                ctx,
                                this.mMode,
                                newNameAbs,
                                src,
                                this.mListener, null);

                    // Compression
                    } else {
                        // Only the first item from the list is valid. If there are more in the
                        // list, then discard them
                        String src = this.mFsos.get(0).getFullPath();

                        // Do the compression
                        this.cmd =
                           CommandHelper.compress(
                                ctx,
                                this.mMode,
                                src,
                                this.mListener, null);
                    }
                    out = this.cmd.getOutCompressedFile();

                    // Request paint the
                    this.mListener.mQueue.insert(out);
                    task.onRequestProgress();

                    // Don't use an active blocking because this suppose that all message
                    // will be processed by the UI. Instead, refresh with a delay and
                    // display the active file
                    while (!this.mListener.mEnd) {
                        // Sleep to don't saturate the UI thread
                        Thread.sleep(50L);

                        List<String> msgs = this.mListener.mQueue.peekAll();
                        if (msgs.size() > 0) {
                            this.mMsg = msgs.get(msgs.size()-1);
                            task.onRequestProgress();
                        }
                    }

                    // Dialog is ended. Force the last redraw
                    List<String> msgs = this.mListener.mQueue.peekAll();
                    if (msgs.size() > 0) {
                        this.mMsg = msgs.get(msgs.size()-1);
                        task.onRequestProgress();
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


                // Any exception?
                Thread.sleep(100L);
                if (this.mListener.mCause != null) {
                    throw this.mListener.mCause;
                }

                // Check that the operation was completed retrieving the compressed file or folder
                boolean failed = false;
                try {
                    FileSystemObject fso = CommandHelper.getFileInfo(ctx, out, false, null);
                    if (fso == null) {
                        // Failed. The file or folder not exists
                        failed = true;
                    }

                    // Operation complete successfully

                } catch (Throwable e) {
                    // Failed. The file or folder not exists
                    failed = true;
                }
                if (failed) {
                    throw new ExecutionException(
                            String.format(
                                    "Failed to compress file(s) to: %s", out)); //$NON-NLS-1$
                }
            }
        };
        final BackgroundAsyncTask task = new BackgroundAsyncTask(ctx, callable);

        // Check if the output exists. When the mode is archive, this method generate a new
        // name based in the current directory. When the mode is compressed then the name
        // is the name of the file to compress without extension. In this case the name should
        // be validate prior to compress
        boolean askUser = false;
        try {
            if (!mode.mArchive) {
                // Only the first item from the list is valid. If there are more in the
                // list, then discard them
                String src = fsos.get(0).getFullPath();
                CompressExecutable ucmd =
                        FileManagerApplication.getBackgroundConsole().
                            getExecutableFactory().newCreator().
                                createCompressExecutable(mode, src, null);
                String dst = ucmd.getOutCompressedFile();
                FileSystemObject info = CommandHelper.getFileInfo(ctx, dst, null);
                if (info != null) {
                    askUser = true;
                }
            }
        } catch (Exception e) {/**NON BLOCK**/}

        // Ask the user because the destination file or folder exists
        if (askUser) {
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
        } else {
            // Execute background task
            task.execute(task);
        }
    }

