	private synchronized void playPause() {
		if (mp.isPlaying()) {
			pause();
		} else {
			play();
		}
	}

