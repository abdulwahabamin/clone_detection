	/***************************************************************************************
	 * <p>
	 * Queries Google's servers for a list of all songs in the current Google account's 
	 * music library.
	 * </p>
	 * 
	 * @deprecated The use of this method is highly discouraged as it sends/fetches large 
	 * amounts of data from Google's servers. All of this data is readily available via the 
	 * Google Play Music app's public ContentProvider. This method uses the WebClient 
	 * endpoint.
	 * 
	 * @param context The context to use during the download process.
	 * @param continuationToken The token that will return the next set of songs (only 1000 
	 * songs are returned per request).
	 * @return
	 * @throws JSONException
	 ***************************************************************************************/
	public static final ArrayList<WebClientSongsSchema> getSongs(Context context, 
																 String continuationToken) 
																 throws JSONException {

		JSONForm form = new JSONForm();
		form.addField("json", "{\"continuationToken\":\"" + continuationToken + "\"}");
		form.close();

		String response = mHttpClient.post(context, 
										   "https://play.google.com/music/services/loadalltracks?u=0&xt=" + getXtCookieValue(), 
										   new ByteArrayEntity(form.toString().getBytes()), 
										   form.getContentType());
		
		JSONObject jsonObject = new JSONObject(response);
		WebClientPlaylistsSchema playlist = new WebClientPlaylistsSchema().fromJsonObject(jsonObject);

		ArrayList<WebClientSongsSchema> chunkedSongList = new ArrayList<WebClientSongsSchema>();
		chunkedSongList.addAll(playlist.getPlaylist());

		if(!TextUtils.isEmpty(playlist.getContinuationToken())) {
			chunkedSongList.addAll(getSongs(context, playlist.getContinuationToken()));
		}

		return chunkedSongList;
	}

