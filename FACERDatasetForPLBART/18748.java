	/****************************************************************************
	 * Creates a new, user generated playlist. This method only creates the 
	 * playlist; it does not add songs to the playlist.
	 * 
	 * @param context The context to use while creating the new playlist.
	 * @param playlistName The name of the new playlist.
	 * @return Returns the playlistId of the newly created playlist.
	 * @throws JSONException
	 * @throws IllegalArgumentException
	 ****************************************************************************/
	public final static String createPlaylist(Context context, String playlistName) 
							   throws JSONException, IllegalArgumentException {
		
		JSONObject jsonParam = new JSONObject();
		JSONArray mutationsArray = new JSONArray();
		JSONObject createObject = new JSONObject();

		createObject.put("lastModifiedTimestamp", "0");
		createObject.put("name", playlistName);
		createObject.put("creationTimestamp", "-1");
		createObject.put("type", "USER_GENERATED");
		createObject.put("deleted", false);
		
		mutationsArray.put(new JSONObject().put("create", createObject));
		jsonParam.put("mutations", mutationsArray);

		mHttpClient.setUserAgent(mMobileClientUserAgent);
		String result = mHttpClient.post(context, 
										 "https://www.googleapis.com/sj/v1.1/playlistbatch?alt=json&hl=en_US", 
										 new ByteArrayEntity(jsonParam.toString().getBytes()), 
										 "application/json");
		
		mHttpClient.setUserAgent(mWebClientUserAgent);
		return new JSONObject(result).optJSONArray("mutate_response")
									 .getJSONObject(0).optString("id");
	}

