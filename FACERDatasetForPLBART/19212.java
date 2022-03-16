	/**
	 * Called when the user taps on the "Play all" or "Shuffle all" action button.
	 */
	public void playAll(boolean shuffle) {
		//Start the playback sequence.
		mApp.getPlaybackKickstarter().initPlayback(mContext, "", Common.PLAY_ALL_SONGS, 0, true, true);

	}

