    /**
     * Method that sends a {@link FileSystemObject} with the default registered application
     * by the system, or ask the user for select a registered application.
     *
     * @param ctx The current context
     * @param fso The file system object
     * @param onDismissListener The dismiss listener
     */
    public static void sendFileSystemObject(
            final Context ctx, final FileSystemObject fso, OnDismissListener onDismissListener) {
        try {
            // Resolve the intent
            resolveIntent(
                    ctx,
                    getFsoSendIntent(ctx, fso),
                    false,
                    onDismissListener);

        } catch (Exception e) {
            ExceptionUtil.translateException(ctx, e);
        }
    }

