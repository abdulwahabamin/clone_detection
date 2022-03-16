    /**
     * Method that returns the best Uri for the file (content uri, file uri, ...)
     *
     * @param ctx The current context
     * @param file The file to resolve
     */
    private static Uri getUriFromFile(Context ctx, FileSystemObject fso) {
        // If the passed object is secure file then we have to provide access with
        // the internal resource provider
        if (fso.isSecure() && SecureConsole.isVirtualStorageResource(fso.getFullPath())
                && fso instanceof RegularFile) {
            RegularFile file = (RegularFile) fso;
            return SecureResourceProvider.createAuthorizationUri(file);
        }

        // Try to resolve media data or return a file uri
        final File file = new File(fso.getFullPath());
        Uri uri = MediaHelper.fileToContentUri(ctx, file);
        if (uri == null) {
            uri = Uri.fromFile(file);
        }
        return uri;
    }

