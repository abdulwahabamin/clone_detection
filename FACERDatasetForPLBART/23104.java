	private boolean initMediaPlayer() {
		startForeground(NOTIFICATION_ID, notiBuilder.getNotification());
		AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
		int result = audioManager.requestAudioFocus(audioFocusChangeList, AudioManager.STREAM_MUSIC,
				AudioManager.AUDIOFOCUS_GAIN);
		if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
			mMediaPlayer = new MediaPlayer(); // initialize it here
			mMediaPlayer.setOnPreparedListener(this);
			mMediaPlayer.setOnCompletionListener(onCompletion);
			mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			// prevent CPU from going to sleep
			mMediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
			return true;
		} else {
			Log.w(LOG_TAG, "The service hasn't got the audio focus");
		}
		return false;
	}

