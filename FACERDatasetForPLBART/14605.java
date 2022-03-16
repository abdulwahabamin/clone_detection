    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Check for database errors
        if (data == null) {
            return;
        }

        mAlbumIdIndex = data.getColumnIndexOrThrow(BaseColumns._ID);
        mAlbumNameIndex = data.getColumnIndexOrThrow(AlbumColumns.ALBUM);
        mSongCountIndex = data.getColumnIndexOrThrow(AlbumColumns.NUMBER_OF_SONGS);
        mArtistNameIndex = data.getColumnIndexOrThrow(AlbumColumns.ARTIST);
        mArtistAlbumAdapter.changeCursor(data);
        mCursor = data;
    }

