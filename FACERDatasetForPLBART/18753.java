	/******************************************************************************************
	 * Executes a single/batch modification operation on a playlist's entry(ies). This method 
	 * is a general purpose method that simply hits the MobileClient endpoints using
	 * mPlaylistEntriesMutationsArray. Supported mutation operations include "create", 
	 * "delete", and "update". 
	 * 
	 * @param context The context to use while carrying out the modification operation.
	 * @param mutationsArray The JSONArray that contains the mutations command to be 
	 * carried out.
	 * @return The JSON response as a String.
	 * @throws JSONException
	 * @throws IllegalArgumentException
	 ******************************************************************************************/
	public static final String modifyPlaylist(Context context) 
							   throws JSONException, IllegalArgumentException {
		
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("mutations", mPlaylistEntriesMutationsArray);
		
		mHttpClient.setUserAgent(mMobileClientUserAgent);
		String result = mHttpClient.post(context, 
										 "https://www.googleapis.com/sj/v1.1/plentriesbatch?alt=json&hl=en_US", 
										 new ByteArrayEntity(jsonParam.toString().getBytes()), 
										 "application/json");
		
		mHttpClient.setUserAgent(mWebClientUserAgent);
		
		//Clear out and reset the mutationsArray now that we're done using it.
		mPlaylistEntriesMutationsArray = null;
		mPlaylistEntriesMutationsArray = new JSONArray();
		
		return result;
	}    

