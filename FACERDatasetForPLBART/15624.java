    /**
     * Reload the queue after we remove a track
     */
    private void reloadQueueCursor() {
        String[] cols = new String[] {
                BaseColumns._ID, MediaColumns.TITLE, MediaColumns.DATA, AudioColumns.ALBUM,
                AudioColumns.ARTIST, AudioColumns.ARTIST_ID
        };
        StringBuilder selection = new StringBuilder();
        selection.append(AudioColumns.IS_MUSIC + "=1");
        selection.append(" AND " + MediaColumns.TITLE + " != ''");
        Uri uri = Audio.Media.EXTERNAL_CONTENT_URI;
        long[] mNowPlaying = MusicUtils.getQueue();
        if (mNowPlaying.length == 0) {
        }
        selection = new StringBuilder();
        selection.append(BaseColumns._ID + " IN (");
        for (int i = 0; i < mNowPlaying.length; i++) {
            selection.append(mNowPlaying[i]);
            if (i < mNowPlaying.length - 1) {
                selection.append(",");
            }
        }
        selection.append(")");
		if(mCursor != null)
			mCursor.close();
        mCursor = MusicUtils.query(getActivity(), uri, cols, selection.toString(), null, null);
        String[] audioCols = new String[] { BaseColumns._ID, MediaColumns.TITLE, AudioColumns.ARTIST, AudioColumns.ALBUM}; 
        MatrixCursor playlistCursor = new MatrixCursor(audioCols);
    	for(int i = 0; i < mNowPlaying.length; i++){
    		mCursor.moveToPosition(-1);
    		while (mCursor.moveToNext()) {
                long audioid = mCursor.getLong(mCursor.getColumnIndexOrThrow(BaseColumns._ID));
            	if( audioid == mNowPlaying[i]) {
                    String trackName = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaColumns.TITLE));
                    String artistName = mCursor.getString(mCursor.getColumnIndexOrThrow(AudioColumns.ARTIST));
                    String albumName = mCursor.getString(mCursor.getColumnIndexOrThrow(AudioColumns.ALBUM));
            		playlistCursor.addRow(new Object[] {audioid, trackName, artistName ,albumName});

            	}
            }
    	}
		if(mCursor != null)
			mCursor.close();
        mCursor = playlistCursor;
        mAdapter.changeCursor(playlistCursor);
    }

