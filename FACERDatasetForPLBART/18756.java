	/******************************************************************************************
	 * Retrieves a JSONAray with all songs in <i><b>every</b></i> playlist. The JSONArray 
	 * contains the fields of the songs such as "id", "clientId", "trackId", etc. (for a list 
	 * of all fields, see MobileClientPlaylistEntriesSchema.java). 
	 * 
	 * @deprecated This method is fully functional. However, there are issues with retrieving 
	 * the correct playlist entryIds. Specifically, the entryIds do not seem to work with 
	 * reordering playlists via the MobileClient mutations protocol. 
	 * 
	 * @return A JSONArray object that contains all songs and their fields within every playlist. 
	 * @param context The context to use while retrieving songs from the playlist.
	 ******************************************************************************************/
	public static final JSONArray getPlaylistEntriesMobileClient(Context context) 
								  throws JSONException, IllegalArgumentException {
		
		JSONArray playlistEntriesJSONArray = new JSONArray();
		JSONObject jsonRequestParams = new JSONObject();
		
		jsonRequestParams.put("max-results", 10000);
		jsonRequestParams.put("start-token", "0");
		
		mHttpClient.setUserAgent(mMobileClientUserAgent);
		String result = mHttpClient.post(context, 
				 						 "https://www.googleapis.com/sj/v1.1/plentryfeed?alt=json&hl=en_US&tier=basic", 
				 						 new ByteArrayEntity(jsonRequestParams.toString().getBytes()), 
				 						 "application/json");
		
		JSONObject resultJSONObject = new JSONObject(result);
		JSONObject dataJSONObject = new JSONObject();
		
		if (resultJSONObject!=null) {
			dataJSONObject = resultJSONObject.optJSONObject("data");
		}
		
		if (dataJSONObject!=null) {
			playlistEntriesJSONArray = dataJSONObject.getJSONArray("items");
		}
		
		return playlistEntriesJSONArray;
	}

