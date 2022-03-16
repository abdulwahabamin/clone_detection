    /**
     * Method that remove an existing file system object.
     *
     * @param ctx The current context
     * @param src The source file system object
     * @param lnkName The new name of the link
     * @param onSelectionListener The listener for obtain selection information (required)
     * @param onRequestRefreshListener The listener for request a refresh (optional)
     */
    public static void createSymlink(
            final Context ctx,
            final FileSystemObject src,
            final String lnkName,
            final OnSelectionListener onSelectionListener,
            final OnRequestRefreshListener onRequestRefreshListener) {

        //Create the absolute file name
        File newFso = new File(
                onSelectionListener.onRequestCurrentDir(), lnkName);
        final String link = newFso.getAbsolutePath();

        try {
            if (DEBUG) {
                Log.d(TAG, String.format(
                        "Creating new symlink: %s -> %s", src.getFullPath(), link)); //$NON-NLS-1$
            }
            CommandHelper.createLink(ctx, src.getFullPath(), link, null);

            //Operation complete. Show refresh
            if (onRequestRefreshListener != null) {
                FileSystemObject fso = null;
                try {
                    fso = CommandHelper.getFileInfo(ctx, link, false, null);
                } catch (Throwable ex2) {
                    /**NON BLOCK**/
                }
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
                                fso = CommandHelper.getFileInfo(ctx, link, false, null);
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

