    /**
     * Method that resolves the content uri to a valid system path
     *
     * @param ctx The current context
     * @param uri The content uri
     * @return String The system path
     */
    private static String uriToPath(Context ctx, Uri uri) {
        File file = MediaHelper.contentUriToFile(ctx.getContentResolver(), uri);
        if (file == null) {
            file = new File(uri.getPath());
        }
        return file.getAbsolutePath();
    }

