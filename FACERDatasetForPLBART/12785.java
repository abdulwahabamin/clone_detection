    /**
     * Method that uncompress a compressed file.
     *
     * @param ctx The current context
     * @param fso The compressed file
     * @param onRequestRefreshListener The listener for request a refresh (optional)
     * @hide
     */
    public static void uncompress(
            final Context ctx, final FileSystemObject fso,
            final OnRequestRefreshListener onRequestRefreshListener) {

        // The callable interface
        final BackgroundCallable callable = new BackgroundCallable() {
            // The current items
            final Context mCtx = ctx;
            final FileSystemObject mFso = fso;
            final OnRequestRefreshListener mOnRequestRefreshListener = onRequestRefreshListener;

            final Object mSync = new Object();
            Throwable mCause;
            UncompressExecutable cmd;

            final CompressListener mListener =
                                new CompressListener();
            private String mMsg;
            private boolean mStarted = false;

            @Override
            public int getDialogTitle() {
                return R.string.waiting_dialog_extracting_title;
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
                              R.string.waiting_dialog_extracting_msg,
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
                            R.string.msgs_extracting_success,
                            this.cmd.getOutUncompressedFile());
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
                    this.cmd =
                        CommandHelper.uncompress(
                                ctx,
                                this.mFso.getFullPath(),
                                null,
                                this.mListener, null);
                    out = this.cmd.getOutUncompressedFile();

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

                // Check that the operation was completed retrieving the uncompressed
                // file or folder
                boolean failed = false;
                try {
                    FileSystemObject fso2 = CommandHelper.getFileInfo(ctx, out, false, null);
                    if (fso2 == null) {
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
                                    "Failed to extract file: %s", //$NON-NLS-1$
                                    this.mFso.getFullPath()));
                }
            }
        };
        final BackgroundAsyncTask task = new BackgroundAsyncTask(ctx, callable);

        // Check if the output exists
        boolean askUser = false;
        try {
            UncompressExecutable ucmd =
                    FileManagerApplication.getBackgroundConsole().
                        getExecutableFactory().newCreator().
                            createUncompressExecutable(fso.getFullPath(), null, null);
            String dst = ucmd.getOutUncompressedFile();
            FileSystemObject info = CommandHelper.getFileInfo(ctx, dst, null);
            if (info != null) {
                askUser = true;
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
                                        // Check if the necessary to display a warning because
                                        // security issues
                                        checkZipSecurityWarning(ctx, task, fso);
                                    }
                                }
                           });
            DialogHelper.delegateDialogShow(ctx, dialog);
        } else {
            // Execute background task
            task.execute(task);
        }
    }

