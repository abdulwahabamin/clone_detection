    /**
     * Method that converts a file reference to a content uri reference
     *
     * @param cr A content resolver
     * @param path The path to search
     * @param volume The volume
     * @return Uri The content uri or null if file not exists in the media database
     */
    private static Uri fileToContentUri(Context context, String path, String volume) {
        String[] projection = null;
        final String where = MediaColumns.DATA + " = ?";
        File file = new File(path);
        Uri baseUri = MediaStore.Files.getContentUri(volume);
        boolean isMimeTypeImage = false, isMimeTypeVideo = false, isMimeTypeAudio = false;
        isMimeTypeImage = MimeTypeHelper.KnownMimeTypeResolver.isImage(context, file);
        if (!isMimeTypeImage) {
            isMimeTypeVideo = MimeTypeHelper.KnownMimeTypeResolver.isVideo(context, file);
            if (!isMimeTypeVideo) {
                isMimeTypeAudio = MimeTypeHelper.KnownMimeTypeResolver.isAudio(context, file);
            }
        }
        if (isMimeTypeImage || isMimeTypeVideo || isMimeTypeAudio) {
            projection = new String[]{BaseColumns._ID};
            if (isMimeTypeImage) {
                baseUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if (isMimeTypeVideo) {
                baseUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if (isMimeTypeAudio) {
                baseUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
        } else {
            projection = new String[]{BaseColumns._ID, MediaStore.Files.FileColumns.MEDIA_TYPE};
        }
        ContentResolver cr = context.getContentResolver();
        Cursor c = cr.query(baseUri, projection, where, new String[]{path}, null);
        try {
            if (c != null && c.moveToNext()) {
                boolean isValid = false;
                if (isMimeTypeImage || isMimeTypeVideo || isMimeTypeAudio) {
                    isValid = true;
                } else {
                    int type = c.getInt(c.getColumnIndexOrThrow(
                        MediaStore.Files.FileColumns.MEDIA_TYPE));
                    isValid = type != 0;
                }
                if (isValid) {
                    // Do not force to use content uri for no media files
                    long id = c.getLong(c.getColumnIndexOrThrow(BaseColumns._ID));
                    return Uri.withAppendedPath(baseUri, String.valueOf(id));
                }
            }
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return null;
    }

