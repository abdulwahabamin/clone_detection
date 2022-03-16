    @Override
    public String getType(Uri uri) {
        switch (sURIMatcher.match(uri)) {
            case FOLDER:
                return MusicContract.Folder.CONTENT_TYPE;

            case PLAYLIST:
                return MusicContract.Playlist.CONTENT_TYPE;

            case GENRE:
                return MusicContract.Genre.CONTENT_TYPE;

            case ARTIST:
                return MusicContract.Artist.CONTENT_TYPE;

            case ALBUM:
                return MusicContract.Album.CONTENT_TYPE;

            case FOLDER_MEMBERS:
            case PLAYLIST_MEMBERS:
            case GENRE_MEMBERS:
            case ARTIST_MEMBERS:
            case ALBUM_MEMBERS:
            case MUSIC_MEMBERS:
                return MusicContract.CONTENT_TYPE;

            default:
                return null;
        }
    }

