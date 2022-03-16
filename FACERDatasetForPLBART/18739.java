	/******************************************************************
	 * Sets the HTTP client's authorization header using the specified 
	 * authentication token. The header will be in the following form: 
	 * 
	 * "Authorization", "GoogleLogin auth=xxxxxxxxxxxxxx",
	 * 
	 * where "xxxxxxxxxxxxxxx" is the authentication token.
	 * 
	 * @param authToken The authentication token that will be used to 
	 * set the header.
	 ******************************************************************/
	public static final void setAuthorizationHeader(String authToken) {
		mAuthToken = authToken;
		mHttpClient.addHeader("Authorization", "GoogleLogin auth=" + mAuthToken);
	}

