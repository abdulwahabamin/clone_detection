	public void toggleShuffle(){
		Log.d(TAG, "Shuffle clicked...");
		Message msg = Message.obtain(null, MusicPlaybackService.MSG_TOGGLE_SHUFFLE);
		try {
			Log.i(TAG, "Sending a request to toggle shuffle!");
			mService.send(msg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

