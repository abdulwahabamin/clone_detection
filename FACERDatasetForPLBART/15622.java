    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data == null) {
            return;
        }
        long[] mNowPlaying = MusicUtils.getQueue();
    	String[] audioCols = new String[] { BaseColumns._ID, MediaColumns.TITLE, AudioColumns.ARTIST, AudioColumns.ALBUM};
        MatrixCursor playlistCursor = new MatrixCursor(audioCols);
    	for(int i = 0; i < mNowPlaying.length; i++){
    		data.moveToPosition(-1);
    		while (data.moveToNext()) {
                long audioid = data.getLong(data.getColumnIndexOrThrow(BaseColumns._ID));
            	if( audioid == mNowPlaying[i]) {
                    String trackName = data.getString(data.getColumnIndexOrThrow(MediaColumns.TITLE));
                    String artistName = data.getString(data.getColumnIndexOrThrow(AudioColumns.ARTIST));
                    String albumName = data.getString(data.getColumnIndexOrThrow(AudioColumns.ALBUM));
            		playlistCursor.addRow(new Object[] {audioid, trackName, artistName, albumName });
            	}
            }
    	}
        data.close();
		mCursor = playlistCursor;
        super.onLoadFinished(loader, playlistCursor);
    }

