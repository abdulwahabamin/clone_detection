	/**
	 * Initializes the MediaPlayer objects for this service session.
	 */
	private void initMediaPlayers() {
		
		/*
		 * Release the MediaPlayer objects if they are still valid.
		 */
		if (mMediaPlayer!=null) {
			mMediaPlayer.release();
			mMediaPlayer = null;
		}
		
		if (mMediaPlayer2!=null) {
			getMediaPlayer2().release();
			mMediaPlayer2 = null;
		}
		
		mMediaPlayer = new MediaPlayer();
		mMediaPlayer2 = new MediaPlayer();
		setCurrentMediaPlayer(1);
		
		getMediaPlayer().reset();
		getMediaPlayer2().reset();
		
		//Loop the players if the repeat mode is set to repeat the current song.
		if (getRepeatMode()==Common.REPEAT_SONG) {
			getMediaPlayer().setLooping(true);
			getMediaPlayer2().setLooping(true);
		}
		
		try {
			mMediaPlayer.setWakeMode(mContext, PowerManager.PARTIAL_WAKE_LOCK);
			getMediaPlayer2().setWakeMode(mContext, PowerManager.PARTIAL_WAKE_LOCK);
		} catch (Exception e) {
			mMediaPlayer = new MediaPlayer();
			mMediaPlayer2 = new MediaPlayer();
			setCurrentMediaPlayer(1);
		}

		//Set the mediaPlayers' stream sources.
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		getMediaPlayer2().setAudioStreamType(AudioManager.STREAM_MUSIC);
		
	}

