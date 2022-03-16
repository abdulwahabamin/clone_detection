    /**
     * Clear the mount point usage data for the file root
     *
     * @param context  {@link android.content.Context} not null
     * @param fileRoot {@link java.lang.String} not null or empty
     *
     * @return {@link java.lang.Integer}
     *
     * @throws IllegalArgumentException {@link java.lang.IllegalArgumentException}
     */
    public static int clearMountPointUsages(Context context, String fileRoot)  throws
            IllegalArgumentException {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        if (TextUtils.isEmpty(fileRoot)) {
            throw new IllegalArgumentException("'fileRoot' cannot be null or empty!");
        }
                String selection = COLUMN_FILE_ROOT + " = ?";
        String[] selectionArgs = new String[] { fileRoot };
        return context.getContentResolver().delete(MimeTypeIndexProvider.getContentUri(), selection, selectionArgs);
    }

