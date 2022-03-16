	/*******************************************************************************************
	 * Returns the number of elements in mPlaylistEntriesMutationsArray. Used to check if a 
	 * POST request should be sent to Google's servers.
	 *******************************************************************************************/
	public static int getQueuedMutationsCount() {
		return mPlaylistEntriesMutationsArray.length();
	}

