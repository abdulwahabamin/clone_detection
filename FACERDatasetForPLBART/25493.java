	public void previous(){
		Log.d(TAG, "Previous clicked...");
		Message msg = Message.obtain(null, MusicPlaybackService.MSG_PREVIOUS);
		try {
			Log.i(TAG, "Sending a request to go to previous!");
			mService.send(msg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

