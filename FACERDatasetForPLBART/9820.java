    /**
     * Kick off an indexing job for the provided file root or mount point root
     *
     * @param context  {@link android.content.Context}
     * @param fileRoot {@link java.lang.String}
     *
     * @throws IllegalArgumentException {@link java.lang.IllegalArgumentException}
     */
    public static void indexFileRoot(Context context, String fileRoot) throws
            IllegalArgumentException {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null");
        }
        // Start indexing the external storage
        Intent intent = new Intent(context, MimeTypeIndexService.class);
        intent.setAction(MimeTypeIndexService.ACTION_START_INDEX);
        intent.putExtra(MimeTypeIndexService.EXTRA_FILE_ROOT, fileRoot);
        context.startService(intent);
    }

