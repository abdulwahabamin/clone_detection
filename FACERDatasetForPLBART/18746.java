	/***************************************************************************************
	 * @deprecated The use of this method is highly discouraged as it sends/fetches large 
	 * amounts of data from Google's servers. All of this data is readily available via the 
	 * Google Play Music app's public ContentProvider. This method uses the WebClient 
	 * endpoint and is a helper method for getSongs().
	 * 
	 * @param context The context to use during the download process.
	 * @return
	 * @throws JSONException
	 ***************************************************************************************/
	public static final ArrayList<WebClientSongsSchema> getAllSongs(Context context) 
														throws JSONException {
		return getSongs(context, "");
	}

