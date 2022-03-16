    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Check for database errors
        if (data == null) {
            return;
        }

        mAlbumIdIndex = data.getColumnIndexOrThrow(BaseColumns._ID);
        mAlbumNameIndex = data.getColumnIndexOrThrow(AlbumColumns.ALBUM);
        mArtistNameIndex = data.getColumnIndexOrThrow(AlbumColumns.ARTIST);
        mAlbumAdapter.changeCursor(data);
        mCursor = data;
    }

