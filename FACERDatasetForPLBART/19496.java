	/**
	 * Registers the headset plug receiver.
	 */
	public void registerHeadsetPlugReceiver() {
		//Register the headset plug receiver.
		if (mApp.getSharedPreferences().getString("UNPLUG_ACTION", "PAUSE_MUSIC_PLAYBACK").equals("PAUSE_MUSIC_PLAYBACK")) {
			IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
			mHeadsetPlugReceiver = new HeadsetPlugBroadcastReceiver();
		    mService.registerReceiver(mHeadsetPlugReceiver, filter);
		}
		
	}

