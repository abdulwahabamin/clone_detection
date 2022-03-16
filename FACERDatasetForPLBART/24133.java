    @Override
    public void close() {
        if (mCurrentPlaylistCursor != null)
            mCurrentPlaylistCursor.close();
        super.close();
    }

