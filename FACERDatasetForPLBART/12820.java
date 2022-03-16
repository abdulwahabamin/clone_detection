    /**
     * Method that sends a {@link FileSystemObject} with the default registered application
     * by the system, or ask the user for select a registered application.
     *
     * @param ctx The current context
     * @param fsos The file system objects
     * @param onDismissListener The dismiss listener
     */
    public static void sendMultipleFileSystemObject(
            final Context ctx, final List<FileSystemObject> fsos,
            OnDismissListener onDismissListener) {
        try {
            // Resolve the intent
            resolveIntent(
                    ctx,
                    getFsoSendIntent(ctx, fsos),
                    false,
                    onDismissListener);

        } catch (Exception e) {
            ExceptionUtil.translateException(ctx, e);
        }
    }

