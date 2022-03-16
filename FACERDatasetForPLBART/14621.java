    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Check for database errors
        if (data == null) {
            return;
        }

        mGenreIdIndex = data.getColumnIndexOrThrow(Audio.Genres._ID);
        mGenreNameIndex = data.getColumnIndexOrThrow(Audio.Genres.NAME);
        mGenreAdapter.changeCursor(data);
        mCursor = data;
    }

