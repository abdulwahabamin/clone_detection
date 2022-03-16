	/*********************************************************
	 * Sets the user agent for webclient calls.
	 * 
	 * @param userAgent
	 *********************************************************/
	public static final void setWebClientUserAgent(String userAgent) {
		mWebClientUserAgent = userAgent;
		mHttpClient.setUserAgent(mWebClientUserAgent);
	}

