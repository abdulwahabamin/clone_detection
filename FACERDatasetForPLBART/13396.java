    /**
     * Method that returns an array with all the unique albums paths and ids.
     *
     * @param cr The ContentResolver
     * @return Map<String, Long> The albums map
     */
    public static Map<String, Long> getAllAlbums(ContentResolver cr) {
        Map<String, Long> albums = new HashMap<String, Long>();
        final String[] projection =
                {
                    "distinct " + MediaStore.Audio.Media.ALBUM_ID,
                    "substr(" + MediaStore.Audio.Media.DATA + ", 0, length(" +
                            MediaStore.Audio.Media.DATA + ") - length(" +
                            MediaStore.Audio.Media.DISPLAY_NAME + "))"
                };
        final String where = MediaStore.Audio.Media.IS_MUSIC + " = ?";
        Cursor c = cr.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection, where, new String[]{"1"}, null);
        if (c != null) {
            try {
                while (c.moveToNext()) {
                    long albumId = c.getLong(0);
                    String albumPath = c.getString(1);
                    albums.put(albumPath, albumId);
                }
            } finally {
                c.close();
            }
        }
        return albums;
    }

