	private void playPause(){
		Log.d(TAG, "Play/Pause clicked...");
		Message msg = Message.obtain(null, MusicPlaybackService.MSG_PLAYPAUSE);
		try {
			Log.i(TAG, "Sending a request to start playing!");
			mService.send(msg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

