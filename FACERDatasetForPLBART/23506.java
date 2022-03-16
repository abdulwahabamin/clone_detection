    @Override protected void onListItemClick(ListView l, View v, int position,
            long id) {
        mCursor.moveToPosition(position);
        if (DBG) Log.v(TAG, "Click on " + position + " (id=" + id
                + ", cursid="
                + mCursor.getLong(mCursor.getColumnIndex(MediaStore.Audio.Media._ID))
                + ") in cursor " + mCursor
                + " adapter=" + l.getAdapter());
        setSelected(mCursor);
    }

