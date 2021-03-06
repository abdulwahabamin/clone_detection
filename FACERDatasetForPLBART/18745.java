	/*****************************************************************
	 * Gets the URI of the song stream using the specified song Id. 
	 * The URI is dynamically generated by Google's servers and 
	 * expires after one minute of no usage. This method uses the 
	 * WebClient endpoint.
	 * 
	 * @param songId The id of the song that needs to be streamed.
	 * @return Returns the URI of the song stream.
	 * @throws JSONException
	 * @throws URISyntaxException
	 ******************************************************************/
	public static final URI getSongStream(String songId) 
							throws JSONException, URISyntaxException {

		RequestParams params = new RequestParams();
		params.put("u", "0");
		params.put("songid", songId);
		params.put("pt", "e");
		
		String response = mHttpClient.get("https://play.google.com/music/play", params);

		if (response!=null) {
			JSONObject jsonObject = new JSONObject(response);
			return new URI(jsonObject.optString("url", null));
		}
		
		return null;
	}

