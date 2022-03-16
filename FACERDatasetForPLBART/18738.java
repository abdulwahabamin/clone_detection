	/*************************************************
	 * Returns the raw HTTP client behind the custom 
	 * GMusicHTTPClient implementation.
	 * @return The raw HTTP client object.
	 *************************************************/
	public static final HttpClient getRawHttpClient() {
		return mHttpClient.getHttpClient();
	}

