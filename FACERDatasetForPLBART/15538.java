    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Check for database errors
        if (data == null) {
            return;
        }
        mAdapter.reset();
        mAdapter.changeCursor(data);
        mListView.invalidateViews();
        mCursor = data;
    }

