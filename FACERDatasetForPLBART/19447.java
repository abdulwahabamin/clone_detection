	/**
	 * Attaches the song's metadata to the intent that was initialized in 
	 * <i>initializeActionIntent()</i>.
	 */
	public static void attachMetadata(boolean playing,
									  String artist,
									  String album,
									  String track,
									  int durationInSecs) {
		
		mScrobbleDroidIntent.putExtra("playing", playing);
		mScrobbleDroidIntent.putExtra("artist", artist);
		mScrobbleDroidIntent.putExtra("album", album);
		mScrobbleDroidIntent.putExtra("track", track);
		mScrobbleDroidIntent.putExtra("secs", durationInSecs);
		
	}

