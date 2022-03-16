    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Check for database errors
        if (data == null) {
            return;
        }

        mPlaylistIdIndex = data.getColumnIndexOrThrow(BaseColumns._ID);
        mPlaylistNameIndex = data.getColumnIndexOrThrow(PlaylistsColumns.NAME);
        mPlaylistAdapter.changeCursor(data);
        mCursor = data;
    }

