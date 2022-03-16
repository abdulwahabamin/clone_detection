	/**
	 * This method combines mCursor with the specified newCursor.
	 * 
	 * @param newCursor The new cursor to append to mCursor.
	 * @param playNext Pass true if newCursor should be appeneded after the current song.
	 */
	public void enqueueCursor(Cursor newCursor, boolean playNext) {
		
		Cursor[] cursorArray = { getCursor(), newCursor };
		mMergeCursor = new MergeCursor(cursorArray);
		setCursor(mMergeCursor);
		getCursor().moveToPosition(mPlaybackIndecesList.get(mCurrentSongIndex));
		mEnqueuePerformed = true;
		
		if (playNext) {
        	//Check which mMediaPlayer is currently playing, and prepare the other mediaPlayer.
        	prepareAlternateMediaPlayer();
        	
		}
			
	}

