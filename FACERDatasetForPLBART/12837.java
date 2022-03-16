    /**
     * Method that create the a new file system object.
     *
     * @param ctx The current context
     * @param name The name of the file to be created
     * @param folder If the new {@link FileSystemObject} to create is a folder (true) or a
     * file (false).
     * @param onSelectionListener The selection listener (required)
     * @param onRequestRefreshListener The listener for request a refresh after the new
     * folder was created (option)
     */
    private static void createNewFileSystemObject(
            final Context ctx, final String name, final boolean folder,
            final OnSelectionListener onSelectionListener,
            final OnRequestRefreshListener onRequestRefreshListener) {

        //Create the absolute file name
        File newFso = new File(
                onSelectionListener.onRequestCurrentDir(), name);
        final String newName = newFso.getAbsolutePath();

        try {
            if (folder) {
                if (DEBUG) {
                    Log.d(TAG, String.format("Creating new directory: %s", newName)); //$NON-NLS-1$
                }
                CommandHelper.createDirectory(ctx, newName, null);
            } else {
                if (DEBUG) {
                    Log.d(TAG, String.format("Creating new file: %s", newName)); //$NON-NLS-1$
                }
                CommandHelper.createFile(ctx, newName, null);
            }

            //Operation complete. Show refresh
            if (onRequestRefreshListener != null) {
                FileSystemObject fso = null;
                try {
                    fso = CommandHelper.getFileInfo(ctx, newName, false, null);
                } catch (Throwable ex2) {/**NON BLOCK**/}
                onRequestRefreshListener.onRequestRefresh(fso, false);
            }
            showOperationSuccessMsg(ctx);

        } catch (Throwable ex) {
            //Capture the exception
            if (ex instanceof RelaunchableException) {
                ExceptionUtil.attachAsyncTask(ex, new AsyncTask<Object, Integer, Boolean>() {
                    /**
                     * {@inheritDoc}
                     */
                    @Override
                    protected Boolean doInBackground(Object... params) {
                        //Operation complete. Show refresh
                        if (onRequestRefreshListener != null) {
                            FileSystemObject fso = null;
                            try {
                                fso = CommandHelper.getFileInfo(ctx, newName, false, null);
                            } catch (Throwable ex2) {/**NON BLOCK**/}
                            onRequestRefreshListener.onRequestRefresh(fso, false);
                        }
                        return Boolean.TRUE;
                    }

                    /**
                     * {@inheritDoc}
                     */
                    @Override
                    protected void onPostExecute(Boolean result) {
                        if (result != null && result.booleanValue()) {
                            showOperationSuccessMsg(ctx);
                        }
                    }
                });
            }
            ExceptionUtil.translateException(ctx, ex);
        }
    }

