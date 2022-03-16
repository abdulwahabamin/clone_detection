    @Override
    public List<ListRow> loadInBackground() {
        ContentResolver contentResolver = getContext().getContentResolver();

        // TODO fetch in parallel

        Cursor artistCursor = contentResolver.query(MusicContract.Artist.CONTENT_URI, new String[]{
                MusicContract.Artist._ID,
                MusicContract.Artist.NAME,
                MusicContract.Artist.COUNT,
        }, null, null, null);

        Cursor albumCursor = contentResolver.query(MusicContract.Album.CONTENT_URI, new String[]{
                MusicContract.Album._ID,
                MusicContract.Album.NAME,
                MusicContract.Album.COUNT,
        }, null, null, null);

        Cursor genreCursor = contentResolver.query(MusicContract.Genre.CONTENT_URI, new String[]{
                MusicContract.Genre._ID,
                MusicContract.Genre.NAME,
                MusicContract.Genre._COUNT,
        }, null, null, null);

        Cursor folderCursor = contentResolver.query(MusicContract.Folder.CONTENT_URI, new String[]{
                MusicContract.Folder._ID,
                MusicContract.Folder.NAME,
                MusicContract.Folder._COUNT,
                MusicContract.Folder.PATH,
        }, null, null, null);

        Cursor playlistCursor = contentResolver.query(MusicContract.Playlist.CONTENT_URI, new String[]{
                        MusicContract.Playlist._ID,
                        MusicContract.Playlist.NAME,
                        MusicContract.Playlist._COUNT
                },
                MusicContract.Playlist.NAME + " != ''", null,
                MusicContract.Playlist.NAME);

        ArrayList<ListRow> data = new ArrayList<>(5);

        data.add(readCursor(R.id.artists_section, getContext().getString(R.string.artists_menu), artistCursor, MusicContract.Artist.NAME, MusicContract.Artist.COUNT));
        data.add(readCursor(R.id.albums_section, getContext().getString(R.string.albums_menu), albumCursor, MusicContract.Album.NAME, MusicContract.Album.COUNT));
        data.add(readCursor(R.id.genres_sections, getContext().getString(R.string.genres_menu), genreCursor, MusicContract.Genre.NAME, MusicContract.Genre._COUNT));
        data.add(readFolderCursor(R.id.folders_section, getContext().getString(R.string.folders_menu), folderCursor, MusicContract.Folder.NAME, MusicContract.Folder._COUNT, MusicContract.Folder.PATH));
        data.add(readCursor(R.id.playlists_section, getContext().getString(R.string.playlists_menu), playlistCursor, MusicContract.Playlist.NAME, MusicContract.Playlist._COUNT));

        return data;
    }

