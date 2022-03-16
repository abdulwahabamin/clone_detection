	/*****************************************************************************
	 * Adds the specified JSONObject to mPlaylistEntriesMutationsArray. The added 
	 * JSONObject will be placed under the "create" key. The JSONObject should 
	 * contain valid info about the new playlist entry (song) that will be created.
	 * 
	 * @param createObject The JSONObject that contains the new playlist entry's 
	 * info and will be placed under the "create" key. 
	 *****************************************************************************/
	public static final void putCreatePlaylistEntryRequest(JSONObject createObject)
							 throws JSONException {
		mPlaylistEntriesMutationsArray.put(new JSONObject().put("create", createObject));
	}

