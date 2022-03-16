    /**
     * creates a file uri that references this FileSystemObject
     * @return a file uri
     */
    public Uri getFileUri() {
        Uri uri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_FILE)
                .path(getFullPath())
                .build();

        return uri;
    }

