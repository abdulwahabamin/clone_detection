    private Cursor buildAutoPlaylistsCursor() {
        MatrixCursor cursor = new MatrixCursor(new String[] {
                MediaStore.Audio.Playlists._ID,
                MediaStore.Audio.Playlists.NAME
        }, 2);

        cursor.addRow(Arrays.<Object>asList(MusicContract.Playlist.ALL_SONGS, getContext().getString(R.string.all_songs)));
        cursor.addRow(Arrays.<Object>asList(MusicContract.Playlist.RECENTLY_ADDED_PLAYLIST, getContext().getString(R.string.recentlyadded)));

        return cursor;
    }

