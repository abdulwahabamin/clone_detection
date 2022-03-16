    public static Cursor querySongs(String userName, String selection, String[] selectionArgs) {
        String songTable;
        String albumTable;
        String artistTable;

        if(userName != null) {
            songTable = SongTable.remoteTableName;
            albumTable = AlbumTable.remoteTableName;
            artistTable = ArtistTable.remoteTableName;

            if(selection == null) {
                selection = " WHERE ";
            } else {
                selection = selection + " AND ";
            }

            selection = selection + songTable + "." + SongTable.Columns.REMOTE_USERNAME + "=?"
                    + " AND " + albumTable + "." + AlbumTable.Columns.REMOTE_USERNAME  + "=?"
                    + " AND " + artistTable + "." + ArtistTable.Columns.REMOTE_USERNAME  + "=?";

            String newArgs[];
            if(selectionArgs != null) {
                newArgs = new String[selectionArgs.length + 3];
                System.arraycopy(selectionArgs, 0, newArgs, 0, selectionArgs.length);
                System.arraycopy(new String[]{userName, userName, userName}, 0, newArgs,
                        selectionArgs.length, 3);
            } else {
                newArgs = new String[]{userName, userName, userName};
            }

            selectionArgs = newArgs;
        } else {
            songTable = SongTable.localTableName;
            albumTable = AlbumTable.localTableName;
            artistTable = ArtistTable.localTableName;
        }

        String query = "SELECT * FROM "
                + songTable + " LEFT JOIN " + albumTable
                + " ON " + songTable + "." + SongTable.Columns.ALBUM_ID + "=" + albumTable + "." + AlbumTable.Columns.ALBUM_ID
                + " LEFT JOIN " + artistTable
                + " ON " + songTable + "." + SongTable.Columns.ARTIST_ID + "=" + artistTable + "." + ArtistTable.Columns.ARTIST_ID
                + ((selection==null)? "" : selection)
                + " ORDER BY " + songTable + "." + SongTable.Columns.TITLE;


        return library.getReadableDb().rawQuery(query,selectionArgs);
    }

