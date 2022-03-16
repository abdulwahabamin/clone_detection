	/** Called when MediaPlayer is ready */
	public void onPrepared(MediaPlayer player) {
		player.start();
		sendMusicUpdateToActivity(true, true);
		onPlaying();
	}

