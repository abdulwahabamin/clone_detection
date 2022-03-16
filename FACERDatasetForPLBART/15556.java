	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Check for database errors
        if (data == null) {
            return;
        }
        if(mCursor!=null)
        	mCursor.close();
        mAdapter.changeCursor(data);
        mCursor = data;
	}

