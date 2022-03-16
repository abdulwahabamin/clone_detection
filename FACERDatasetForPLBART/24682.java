	private void pause() {
		if (player != null && isReleased == false) {
			handler.removeCallbacks(updateTimeCallBack);
			if (!isPausing) {
				player.pause();
				isPausing = true;
				
				pauseTimeMills=System.currentTimeMillis();
			}
		}

	}

