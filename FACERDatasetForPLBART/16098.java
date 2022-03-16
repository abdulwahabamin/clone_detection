    public static File getAlbumArt(long albumId) {

        Cursor cursor = library.getReadableDb().query(true, AlbumTable.localTableName,
                new String[]{AlbumTable.Columns.ALBUM_ART},
                AlbumTable.Columns.ALBUM_ID + "=?",
                new String[]{String.valueOf(albumId)},
                null,null,null,null);

        String path;
        if(cursor.moveToFirst()) {
            path = getString(cursor, AlbumTable.Columns.ALBUM_ART);
        } else {
            path = null;
        }

        cursor.close();
        return (path == null) ? null : new File(path);
    }

