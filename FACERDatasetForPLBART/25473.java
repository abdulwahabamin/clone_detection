	@Override
	public synchronized void onDestroy() {
		super.onDestroy();
		unregisterReceiver(headphoneReceiver);
		am.abandonAudioFocus(MusicPlaybackService.this.audioFocusListener);
		mAudioManager.unregisterMediaButtonEventReceiver(cn);
		getApplicationContext().unregisterReceiver(receiver);
		mp.stop();
		mp.reset();
		mp.release();
		if (wakeLock.isHeld()) {
			wakeLock.release();
		}
		Log.i("MyService", "Service Stopped.");
		isRunning = false;
	}

