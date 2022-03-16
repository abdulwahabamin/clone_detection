    /**
     * Method that navigate to parent folder
     *
     * @param ctx The current context
     * @param fso The file system object which to navigate to parent
     * @param onRequestRefreshListener The request listener
     */
    public static void openParentFolder(
            final Context ctx, final FileSystemObject fso,
            OnRequestRefreshListener onRequestRefreshListener) {
        try {
            // Retrieve the parent
            FileSystemObject parent =
                    CommandHelper.getFileInfo(ctx, fso.getParent(), null);
            if (parent == null) {
                throw new NoSuchFileOrDirectory(fso.getParent());
            }

            // Navigate to parent folder
            onRequestRefreshListener.onNavigateTo(parent);

        } catch (Exception e) {
            ExceptionUtil.translateException(ctx, e);
        }
    }

