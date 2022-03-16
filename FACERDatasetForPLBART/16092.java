    public static Cursor getAlbums(String userName) {
        String albumTable;
        String selection = null;
        String selectionArgs[] = null;
        if(userName != null) {
            albumTable = AlbumTable.remoteTableName;
            selection = " WHERE " + AlbumTable.Columns.IS_REMOTE + "=?"
                    + " AND " + AlbumTable.Columns.REMOTE_USERNAME + "=?";
            selectionArgs = new String[]{"1", userName};
        } else {
            albumTable = AlbumTable.localTableName;
        }
        
        String query = "SELECT * FROM " + albumTable
                + ((selection == null)? "" : selection)
                + " ORDER BY " + AlbumTable.Columns.ALBUM_NAME;

        return library.getReadableDb().rawQuery(query, selectionArgs);
    }

