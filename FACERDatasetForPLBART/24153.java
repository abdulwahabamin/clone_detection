    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (sURIMatcher.match(uri)) {
            case FOLDER:
                return fetchFolders();

            case PLAYLIST:
                return fetchPlaylists();

            case GENRE:
                return fetchGenres();

            case ARTIST:
                return fetchArtists();

            case ALBUM:
                return fetchAlbums();

            case FOLDER_MEMBERS:
                return fetchFolder(uri.getLastPathSegment());

            case PLAYLIST_MEMBERS:
                return fetchPlaylist(ContentUris.parseId(uri));

            case GENRE_MEMBERS:
                return fetchGenre(ContentUris.parseId(uri));

            case ARTIST_MEMBERS:
                return fetchArtist(ContentUris.parseId(uri));

            case ALBUM_MEMBERS:
                return fetchAlbum(ContentUris.parseId(uri));

            case MUSIC_MEMBERS:
                return fetchMusic();

            default:
                return null;
        }
    }

