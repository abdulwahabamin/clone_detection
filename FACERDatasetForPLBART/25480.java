	/**
	 * Pause the currently playing song.
	 */
	private synchronized void pause() {
		// Sometimes the call to isPlaying can throw an error "internal/external state mismatch corrected"
		// When this happens, I think the player moves itself to "paused" even though it's still playing.
		//if (mp.isPlaying()) {
		//	mp.pause();
		//} else {
		//	Log.w(TAG, "Odd condition - pause was called but the media player reported that it is already paused");
		try{
			// this is a hack, but it seems to be the most consistent way to address the problem
			// this forces the media player to check its current state before trying to pause.
			int position = mp.getCurrentPosition();
			mp.stop();
			mp.prepare();
			mp.seekTo(position);
			wakeLock.release();
		} catch (Exception e){
			Log.w(TAG, "Caught exception while trying to pause ", e);
		}
		//}
		updateNotification();
	}

