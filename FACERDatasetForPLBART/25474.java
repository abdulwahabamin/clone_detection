	private synchronized void jumpback(){
		if (mp.isPlaying()) {
			int progressMillis = mp.getCurrentPosition();
			if (progressMillis <= 20000) {
				mp.seekTo(0);
			} else {
				mp.seekTo(progressMillis - 20000);
			}
			lastPosition = mp.getCurrentPosition();
		} else {
			// if we're paused but initialized, try to seek
			try{
				int progressMillis = mp.getCurrentPosition();
				if (progressMillis <= 20000) {
					mp.seekTo(0);
				} else {
					mp.seekTo(progressMillis - 20000);
				}
				lastPosition = mp.getCurrentPosition();
			} catch (Exception e){
				Log.w(TAG, "Unable to seek to position, file may not have been loaded");
			}
		}

	}

