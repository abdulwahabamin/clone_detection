	private void stop() {
		if (player != null) {
			if (!isReleased) {
				player.stop();
				player.release();
				isReleased = true;
				handler.removeCallbacks(updateTimeCallBack);
			}
			player = null;
		}

	}

