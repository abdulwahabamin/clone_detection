    @Override
    public void remove(int which) {
        int cursorPos = getCursorPosition(which);
        mCursor.moveToPosition(cursorPos);
        long id = mCursor.getLong(mCursor.getColumnIndexOrThrow(BaseColumns._ID));
        String mName = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaColumns.TITLE));
        MusicUtils.removeTrack(id);
        String message = mContext.getString(R.string.track_removed_from_playlist, mName);
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    	super.remove(which);
    }

