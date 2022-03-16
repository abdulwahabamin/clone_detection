	/*****************************************************************************
	 * Creates a JSONObject object that contains the delete command for the 
	 * specified playlist entry.The object will be added to the JSONArray that 
	 * will be passed on to Google's servers. 
	 * 
	 * @param playlistId The playlistId of the playlist to delete.
	 * @throws JSONException
	 * @throws IllegalArgumentException
	 *****************************************************************************/
	public static final void putDeletePlaylistEntryRequest(String playlistEntryId) 
							 throws JSONException, IllegalArgumentException {
		
		JSONObject deleteObject = new JSONObject();
		deleteObject.put("delete", playlistEntryId);
		mPlaylistEntriesMutationsArray.put(deleteObject);
	}

