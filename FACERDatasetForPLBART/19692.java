	/**
	 * Sends out a local broadcast that notifies all receivers to update
	 * their respective UI elements.
	 */
	public void broadcastUpdateUICommand(String[] updateFlags, String[] flagValues) {
		Intent intent = new Intent(UPDATE_UI_BROADCAST);
		for (int i=0; i < updateFlags.length; i++) {
			intent.putExtra(updateFlags[i], flagValues[i]);
		}

		mLocalBroadcastManager = LocalBroadcastManager.getInstance(mContext);
		mLocalBroadcastManager.sendBroadcast(intent);

	}

