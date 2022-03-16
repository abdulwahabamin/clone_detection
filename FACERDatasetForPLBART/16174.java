    static public Song toSong(Cursor cursor) {
        long _id = Library.getLong(cursor, SongTable.Columns.SONG_ID);
        String filePath = Library.getString(cursor, SongTable.Columns.FILE_PATH);
        String title = Library.getString(cursor, SongTable.Columns.TITLE);
        String album = Library.getString(cursor, AlbumTable.Columns.ALBUM_NAME);
        Long albumId = Library.getLong(cursor, SongTable.Columns.ALBUM_ID);
        String albumArt = Library.getString(cursor, AlbumTable.Columns.ALBUM_ART);
        String artist = Library.getString(cursor, ArtistTable.Columns.ARTIST_NAME);
        Long artistId = Library.getLong(cursor, SongTable.Columns.ARTIST_ID);
        Long duration = Library.getLong(cursor, SongTable.Columns.DURATION);
        String libraryUserName;
        if(Library.getInt(cursor, SongTable.Columns.IS_REMOTE) == 1) {
            libraryUserName = Library.getString(cursor, SongTable.Columns.REMOTE_USERNAME);
        } else  {
            libraryUserName = null;
        }

        return new Song(_id, filePath, title, album, albumId, albumArt, artist, artistId, duration,
                libraryUserName);
    }

