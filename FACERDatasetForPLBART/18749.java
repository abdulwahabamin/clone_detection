	/*****************************************************************************
	 * Creates a JSONObject object that contains the delete command for the 
	 * specified playlist and adds it to the JSONArray that will pass the the 
	 * command on to Google's servers. 
	 * 
	 * @param context The context to use while deleting the playlist.
	 * @param playlistId The playlistId of the playlist to delete.
	 * @throws JSONException
	 * @throws IllegalArgumentException
	 *****************************************************************************/
	public static final String deletePlaylist(Context context, String playlistId) 
							   throws JSONException, IllegalArgumentException {
		
		JSONObject jsonParam = new JSONObject();
		JSONArray mutationsArray = new JSONArray();
		
		mutationsArray.put(new JSONObject().put("delete", playlistId));
		jsonParam.put("mutations", mutationsArray);

		mHttpClient.setUserAgent(mMobileClientUserAgent);
		String result = mHttpClient.post(context, 
										 "https://www.googleapis.com/sj/v1.1/playlistbatch?alt=json&hl=en_US", 
										 new ByteArrayEntity(jsonParam.toString().getBytes()), 
										 "application/json");
		
		mHttpClient.setUserAgent(mWebClientUserAgent);
		return result;
	}

