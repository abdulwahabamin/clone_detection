    @Override
	@SuppressWarnings("deprecation")
    public void deactivate() {
        if (mCurrentPlaylistCursor != null)
            mCurrentPlaylistCursor.deactivate();
    }

