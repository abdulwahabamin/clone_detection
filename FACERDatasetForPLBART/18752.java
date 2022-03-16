	/*****************************************************************************
	 * Adds the specified JSONObject to mPlaylistEntriesMutationsArray. The added 
	 * JSONObject will be placed under the "update" key. The JSONObject should 
	 * contain valid info about the playlist entry that is being updated.
	 * 
	 * @param updateObject The JSONObject that contains the updated playlist entry's 
	 * info and will be placed under the "update" key. 
	 *****************************************************************************/
	public static final void putUpdatePlaylistEntryRequest(JSONObject updateObject)
							 throws JSONException {
		mPlaylistEntriesMutationsArray.put(new JSONObject().put("update", updateObject));
	}

