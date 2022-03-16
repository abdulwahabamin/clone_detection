    /**
     * Get the mount point usage data via sql cursor
     *
     * @param context  {@link android.content.Context} not null
     * @param fileRoot {@link java.lang.String} not null or empty
     *
     * @return {@link android.database.Cursor}
     *
     * @throws IllegalArgumentException {@link java.lang.IllegalArgumentException}
     */
    public static Cursor getMountPointUsage(Context context, String fileRoot) throws
            IllegalArgumentException {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        if (TextUtils.isEmpty(fileRoot)) {
            throw new IllegalArgumentException("'fileRoot' cannot be null or empty!");
        }
        String selection = COLUMN_FILE_ROOT + " = ?";
        String[] selectionArgs = new String[] { fileRoot };
        return context.getContentResolver().query(MimeTypeIndexProvider.getContentUri(),
                null, selection, selectionArgs, null);
    }

