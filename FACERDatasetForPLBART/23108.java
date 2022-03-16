	private void handleCommand(Intent intent) {
		// Play next song in the queue, also use to start with the first song.
		if (intent.getAction().equals(ACTION_NEXT)) {
			playSong(playQueue.getNext());
			// Pause the song
		} else if (intent.getAction().equals(ACTION_PAUSE)) {
			if (isMediaPlayerInit) {
				if (mMediaPlayer.isPlaying()) {
					mMediaPlayer.pause();
					isPausedBecauseOfButton = true;
					onPause();
				}
			}
			// Start the song after pausing
		} else if (intent.getAction().equals(ACTION_PLAY)) {
			if (isMediaPlayerInit) {
				if (!playQueue.isEmpty()) {
					if (isMediaPlayerPaused) {
						mMediaPlayer.start();
						sendMusicUpdateToActivity(true, false);
						onPlaying();
					} else {
						playSong(playQueue.getCurrent());
					}
				}
			}
			// Play the previous song in the play queue.
		} else if (intent.getAction().equals(ACTION_PREVIOUS)) {
			if (mMediaPlayer.getCurrentPosition() <= MIN_TIME_GOING_PREVIOUS) {
				playSong(playQueue.getPrevious());
			} else {
				playSong(playQueue.getCurrent());
			}
		}
	}

