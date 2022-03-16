	/*******************************************************************************************
	 * Sends a POST request to Google's servers and retrieves a JSONArray with all user 
	 * playlists. The JSONArray contains the fields of the playlist such as "id", "name", 
	 * "type", etc. (for a list of all response fields, see MobileClientPlaylistsSchema.java).
	 * 
	 * @return A JSONArray object that contains all user playlists and their fields.
	 * @param context The context to use while retrieving user playlists.
	 *******************************************************************************************/
	public static final JSONArray getUserPlaylistsMobileClient(Context context)
								  throws JSONException, IllegalArgumentException {
		
		JSONObject jsonRequestParams = new JSONObject();
		JSONArray playlistsJSONArray = new JSONArray();
		
		jsonRequestParams.put("max-results", 250);
		jsonRequestParams.put("start-token", "0");
		
		mHttpClient.setUserAgent(mMobileClientUserAgent);
		String result = mHttpClient.post(context, 
				 						 "https://www.googleapis.com/sj/v1.1/playlistfeed?alt=json&hl=en_US&tier=basic", 
				 						 new ByteArrayEntity(jsonRequestParams.toString().getBytes()), 
				 						 "application/json");
		
		JSONObject resultJSONObject = new JSONObject(result);
		JSONObject dataJSONObject = new JSONObject();
		
		if (resultJSONObject!=null) {
			dataJSONObject = resultJSONObject.optJSONObject("data");
		}
		
		if (dataJSONObject!=null) {
			playlistsJSONArray = dataJSONObject.getJSONArray("items");
		}
		
		return playlistsJSONArray;
	}

