	/**
	 * Attaches the song's metadata to the intent that was initialized in 
	 * <i>initializeActionIntent()</i>.
	 */
	public static void attachMetadata(int state,
													String artist,
													String album,
													String track,
													int durationInSecs) {
		mSimpleLastFMIntent.putExtra("state", state);
		mSimpleLastFMIntent.putExtra("app-name", "ACE Music Player");
		mSimpleLastFMIntent.putExtra("app-package", "com.aniruddhc.acemusic.player");
		mSimpleLastFMIntent.putExtra("artist", artist);
		mSimpleLastFMIntent.putExtra("album", album);
		mSimpleLastFMIntent.putExtra("track", track);
		mSimpleLastFMIntent.putExtra("duration", durationInSecs);
		
	}

