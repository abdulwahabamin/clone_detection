    @Override
    public void remove(int which) {
        int cursorPos = getCursorPosition(which);
        mCursor.moveToPosition(cursorPos);
        long id = mCursor.getLong(mCursor.getColumnIndexOrThrow(Playlists.Members.AUDIO_ID));
        String mName = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaColumns.TITLE));
        if (mPlaylistId >= 0) {
            Uri uri = Playlists.Members.getContentUri(EXTERNAL, mPlaylistId);
            mContext.getContentResolver().delete(uri, Playlists.Members.AUDIO_ID + "=" + id,
                    null);
            String message = mContext.getString(R.string.track_removed_from_playlist, mName);
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        }
    	super.remove(which);
    }

