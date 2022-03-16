	private void onTimerTick() {
		long currentTime = System.currentTimeMillis();
		if (pauseTime < currentTime) {
			pause();
		}
		updateResumePosition();
		sendUpdateToClients();
	}

