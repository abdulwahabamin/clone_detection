	/************************************************************************
	 * Resets the current HTTP client object by shutting it down and then 
	 * reinstantiating it. The old cookie store, user agent and authorization 
	 * header will be reused. This process will be done on a separate thread.
	 ************************************************************************/
	public static void resetHttpClient() {
		//Reset the HTTP Client on a separate thread.
		Thread thread = new Thread() {
			
			@Override
			public void run() {
				if (mHttpClient!=null) {
					mHttpClient.getHttpClient().getConnectionManager().shutdown();
					mHttpClient = new GMusicHttpClient();
					mHttpClient.setCookieStore(mCookieStore);
					mHttpClient.setUserAgent(mWebClientUserAgent);
					mHttpClient.addHeader("Authorization", "GoogleLogin auth=" + mAuthToken);
				}
				
			}
			
		};
		thread.start();
		
	}

