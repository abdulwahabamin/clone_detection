    /**
     * @param which
     */
	@Override
    public void removePlaylistItem(int which) {
        mCursor.moveToPosition(which);
        long id = mCursor.getLong(mCursor.getColumnIndexOrThrow(BaseColumns._ID));
        MusicUtils.removeTrack(id);
        reloadQueueCursor();
        mListView.invalidateViews();
    }

