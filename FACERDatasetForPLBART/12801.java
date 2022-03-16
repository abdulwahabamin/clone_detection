    /**
     * Method that remove an existing file system object in background.
     *
     * @param ctx The current context
     * @param files The list of files to remove
     * @param onSelectionListener The listener for obtain selection information (optional)
     * @param onRequestRefreshListener The listener for request a refresh (optional)
     * @param onItemFlingerResponder The flinger responder, only if the action was initialized
     * by a flinger gesture (optional)
     * @hide
     */
    static void removeFileSystemObjectsInBackground(
            final Context ctx, final List<FileSystemObject> files,
            final OnSelectionListener onSelectionListener,
            final OnRequestRefreshListener onRequestRefreshListener,
            final OnItemFlingerResponder onItemFlingerResponder) {

        // Some previous checks prior to execute
        // 1.- Check the operation consistency (only if it is viable)
        if (onSelectionListener != null) {
            final String currentDirectory = onSelectionListener.onRequestCurrentDir();
            if (!checkRemoveConsistency(ctx, files, currentDirectory)) {
                return;
            }
        }
        // 2.- Sort the items by path to avoid delete parents fso prior to child fso
        final List<FileSystemObject> sortedFsos  = new ArrayList<FileSystemObject>(files);
        Collections.sort(sortedFsos, new Comparator<FileSystemObject>() {
            @Override
            public int compare(FileSystemObject lhs, FileSystemObject rhs) {
                return lhs.compareTo(rhs) * -1; //Reverse
            }
        });

        // The callable interface
        final BackgroundCallable callable = new BackgroundCallable() {
            // The current items
            private int mCurrent = 0;
            final Context mCtx = ctx;
            final List<FileSystemObject> mFiles = sortedFsos;
            final OnRequestRefreshListener mOnRequestRefreshListener = onRequestRefreshListener;

            final Object mSync = new Object();
            Throwable mCause;

            @Override
            public int getDialogTitle() {
                return R.string.waiting_dialog_deleting_title;
            }
            @Override
            public int getDialogIcon() {
                return 0;
            }
            @Override
            public boolean isDialogCancellable() {
                return false;
            }

            @Override
            public Spanned requestProgress() {
                FileSystemObject fso = this.mFiles.get(this.mCurrent);

                // Return the current operation
                String progress =
                      this.mCtx.getResources().
                          getString(
                              R.string.waiting_dialog_deleting_msg,
                              fso.getFullPath());
                return Html.fromHtml(progress);
            }

            @Override
            public void onSuccess() {
                //Operation complete.

                // Confirms flinger operation
                if (onItemFlingerResponder != null) {
                    onItemFlingerResponder.accept();
                }

                // Remove orphan bookmark paths
                if (files != null) {
                    for (FileSystemObject fso : files) {
                        Bookmarks.deleteOrphanBookmarks(ctx, fso.getFullPath());
                    }
                }

                // Refresh
                if (this.mOnRequestRefreshListener != null) {
                    // The reference is not the same, so refresh the complete navigation view
                    if (files != null && files.size() == 1) {
                        this.mOnRequestRefreshListener.onRequestRemove(files.get(0), true);
                    } else {
                        this.mOnRequestRefreshListener.onRequestRemove(null, true);
                    }
                }
                ActionsPolicy.showOperationSuccessMsg(ctx);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void doInBackground(Object... params) throws Throwable {
                this.mCause = null;

                // This method expect to receive
                // 1.- BackgroundAsyncTask
                BackgroundAsyncTask task = (BackgroundAsyncTask)params[0];

                int cc = this.mFiles.size();
                for (int i = 0; i < cc; i++) {
                    FileSystemObject fso = this.mFiles.get(i);

                    doOperation(this.mCtx, fso);

                    // Next file
                    this.mCurrent++;
                    if (this.mCurrent < this.mFiles.size()) {
                        task.onRequestProgress();
                    }
                }
            }

            /**
             * Method that deletes the file or directory
             *
             * @param ctx The current context
             * @param fso The file or folder to be deleted
             */
            private void doOperation(
                    final Context ctx, final FileSystemObject fso) throws Throwable {
                try {
                    // Remove the item
                    if (FileHelper.isDirectory(fso)) {
                        CommandHelper.deleteDirectory(ctx, fso.getFullPath(), null);
                    } else {
                        CommandHelper.deleteFile(ctx, fso.getFullPath(), null);
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
                            // Cancels the flinger
                            if (onItemFlingerResponder != null) {
                                onItemFlingerResponder.cancel();
                            }

                            // The exception must be elevated
                            throw this.mCause;
                        }

                    } else {
                        // Cancels the flinger
                        if (onItemFlingerResponder != null) {
                            onItemFlingerResponder.cancel();
                        }

                        // The exception must be elevated
                        throw e;
                    }
                }

                // Check that the operation was completed retrieving the deleted fso
                boolean failed = false;
                try {
                    CommandHelper.getFileInfo(ctx, fso.getFullPath(), false, null);
                    FileSystemObject fso2 =
                            CommandHelper.getFileInfo(ctx, fso.getFullPath(), false, null);
                    if (fso2 != null) {
                        // Failed. The file still exists
                        failed = true;
                    }

                } catch (Throwable e) {
                    // Operation complete successfully
                }
                if (failed) {
                    // Cancels the flinger
                    if (onItemFlingerResponder != null) {
                        onItemFlingerResponder.cancel();
                    }

                    throw new ExecutionException(
                            String.format(
                                    "Failed to delete file: %s", fso.getFullPath())); //$NON-NLS-1$
                }
            }
        };
        final BackgroundAsyncTask task = new BackgroundAsyncTask(ctx, callable);

        // Execute background task
        task.execute(task);
    }

