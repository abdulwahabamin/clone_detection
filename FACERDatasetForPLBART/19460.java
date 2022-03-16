	/**
	 * Requests AudioFocus from the OS.
	 * 
	 * @return True if AudioFocus was gained. False, otherwise.
	 */
	private boolean requestAudioFocus() {
		int result = mAudioManager.requestAudioFocus(audioFocusChangeListener,
     												AudioManager.STREAM_MUSIC,
     												AudioManager.AUDIOFOCUS_GAIN);

		if (result!=AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
			//Stop the service.
			mService.stopSelf();
			Toast.makeText(mContext, R.string.close_other_audio_apps, Toast.LENGTH_LONG).show();
			return false;
		} else {
			return true;
		}
		
	}

