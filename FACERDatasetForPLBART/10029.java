    /**
     * Method that show a new dialog for compute checksum of a {@link FileSystemObject}.
     *
     * @param ctx The current context
     * @param fso The file system object
     * of the {@link FileSystemObject} were changed (optional)
     */
    public static void showComputeChecksumDialog(
            final Context ctx, final FileSystemObject fso) {
        // Check that we have read access
        try {
            FileHelper.ensureReadAccess(
                    ConsoleBuilder.getConsole(ctx),
                    fso,
                    null);

            //Show a the filesystem info dialog
            final ComputeChecksumDialog dialog = new ComputeChecksumDialog(ctx, fso);
            dialog.show();

        } catch (Exception ex) {
            ExceptionUtil.translateException(
                    ctx, ex, false, true, new OnRelaunchCommandResult() {
                @Override
                public void onSuccess() {
                    //Show a the filesystem info dialog
                    final ComputeChecksumDialog dialog = new ComputeChecksumDialog(ctx, fso);
                    dialog.show();
                }

                @Override
                public void onFailed(Throwable cause) {/**NON BLOCK**/}

                @Override
                public void onCancelled() {/**NON BLOCK**/}
            });
        }
    }

