    public static Cursor getAlbumSongs(String userName ,long albumId) {
        String selection = " WHERE "
                + ((userName == null) ? SongTable.localTableName : SongTable.remoteTableName)
                + "." + SongTable.Columns.ALBUM_ID + "=?";
        String[] selectionArgs = {String.valueOf(albumId)};

        return querySongs(userName, selection, selectionArgs);
    }

