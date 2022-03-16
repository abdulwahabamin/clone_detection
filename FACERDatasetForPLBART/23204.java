    public void init(Cursor c) {

        if (mAdapterDestroyed)
           return;
        mAdapter.changeCursor(c); // also sets mAlbumCursor

        if (mAlbumCursor == null) {
            MusicUtils.displayDatabaseError(this);
            closeContextMenu();
            mReScanHandler.sendEmptyMessageDelayed(0, 1000);
            return;
        }
        
        MusicUtils.hideDatabaseError(this);
        setTitle();
    }

