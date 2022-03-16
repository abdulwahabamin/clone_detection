	/**************************************************************************************************
	 * Retrieves a JSONAray with all songs within the <b><i>specified</b></i> playlist. The JSONArray 
	 * contains the fields of the songs such as "id", "clientId", "trackId", etc. (for a list 
	 * of all fields, see WebClientSongsSchema.java). Uses the WebClient endpoint.
	 * 
	 * @return A JSONArray object that contains the songs and their fields within the specified playlist.
	 * @param context The context to use while retrieving songs from the playlist.
	 * @param playlistId The id of the playlist we need to fetch the songs from.
	 **************************************************************************************************/
	public static final JSONArray getPlaylistEntriesWebClient(Context context, String playlistId) 
							      throws JSONException, IllegalArgumentException {
		
		JSONObject jsonParam = new JSONObject();
		jsonParam.putOpt("id", playlistId);

		JSONForm form = new JSONForm();
		form.addField("json", jsonParam.toString());
		form.close();
		
		mHttpClient.setUserAgent(mMobileClientUserAgent);
		String result = mHttpClient.post(context, 
										 "https://play.google.com/music/services/loadplaylist?u=0&xt=" + getXtCookieValue(), 
				 						 new ByteArrayEntity(form.toString().getBytes()), 
				 						 form.getContentType());
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject(result);
		
		if (jsonObject!=null) {
			jsonArray = jsonObject.getJSONArray("playlist");
		}
		
		return jsonArray;
	}

