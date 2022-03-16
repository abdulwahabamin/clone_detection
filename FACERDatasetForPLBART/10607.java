    /**
     * Method that returns the album thumbnail path by its identifier.
     *
     * @param cr The ContentResolver
     * @param albumId The album identifier to search
     * @return String The album thumbnail path
     */
    public static String getAlbumThumbnailPath(ContentResolver cr, long albumId) {
        final String[] projection = {MediaStore.Audio.Albums.ALBUM_ART};
        final String where = BaseColumns._ID + " = ?";
        Cursor c = cr.query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
                projection, where, new String[]{String.valueOf(albumId)}, null);
        try {
            if (c != null && c.moveToNext()) {
                return c.getString(0);
            }
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return null;
    }

