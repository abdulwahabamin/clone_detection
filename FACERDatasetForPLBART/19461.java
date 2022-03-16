	/**
	 * Initializes the equalizer and audio effects for this service session.
	 */
	public void initAudioFX() {

		try {	
	    	//Instatiate the equalizer helper object.
			mEqualizerHelper = new EqualizerHelper(mContext, mMediaPlayer.getAudioSessionId(), 
												   getMediaPlayer2().getAudioSessionId(), 
												   mApp.isEqualizerEnabled());

		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
			mEqualizerHelper.setIsEqualizerSupported(false);
		} catch (Exception e) {
			e.printStackTrace();
			mEqualizerHelper.setIsEqualizerSupported(false);
		}
		
	}

