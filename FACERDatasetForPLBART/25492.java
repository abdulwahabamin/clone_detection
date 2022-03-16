	private void next(){
		Log.d(TAG, "next...");
		Message msg = Message.obtain(null, MusicPlaybackService.MSG_NEXT);
		try {
			Log.i(TAG, "SEnding a request to go to next!");
			mService.send(msg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

