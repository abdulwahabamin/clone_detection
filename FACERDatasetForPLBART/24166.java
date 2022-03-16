    private Cursor fetchPlaylists() {
        Cursor cursor = getContext().getContentResolver().query(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI,
                new String[] {
                        MediaStore.Audio.Playlists._ID,
                        MediaStore.Audio.Playlists.NAME
                },
                null, null,
                MediaStore.Audio.Playlists.NAME);

        if (cursor == null) return null;

        MergeCursor mergeCursor = new MergeCursor(new Cursor[]{buildAutoPlaylistsCursor(), cursor});

        int idColumn = mergeCursor.getColumnIndexOrThrow(MediaStore.Audio.Playlists._ID);
        int[] counts = new int[mergeCursor.getCount()];
        int i = 0;
        while (mergeCursor.moveToNext()) {
            long id = mergeCursor.getLong(idColumn);
            counts[i++] = getCursorCount(fetchPlaylist(id));
        }
        mergeCursor.moveToPosition(-1);

        Cursor finalCursor = new CursorWithCountColumn(mergeCursor, counts);
        finalCursor.setNotificationUri(getContext().getContentResolver(), MusicContract.Playlist.CONTENT_URI);
        return finalCursor;
    }

