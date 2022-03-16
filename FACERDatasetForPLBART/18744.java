	/*******************************************************************************
	 * Attempts to log the user into the "sj" (SkyJam) service using the provided
	 * authentication token. The authentication token is unique for each session 
	 * and user account. It can be obtained via the GoogleAuthUtil.getToken() 
	 * method. See AsyncGoogleMusicAuthenticationTask.java for the current
	 * implementation of this process. This method will return true if the login
	 * process succeeded. Returns false for any other type of failure.
	 * 
	 * @param context The context that will be used for the login process.
	 * @param authToken The authentication token that will be used to login. 
	 *******************************************************************************/
	public static final boolean login(Context context, String authToken) {
		
		if(!TextUtils.isEmpty(authToken))
		{
			JSONForm form = new JSONForm().close();
			GMusicClientCalls.setAuthorizationHeader(authToken);
			String response = mHttpClient.post(context, 
											   "https://play.google.com/music/listen?hl=en&u=0", 
											   new ByteArrayEntity(form.toString().getBytes()), 
											   form.getContentType());
			
			//Check if the required paramters are null.
			if (response!=null) {
				
				if (getXtCookieValue()!=null) {
					return true;
				} else {
					return false;
				}
				
			} else {
				return false;
			}

		} else {
			return false;
		}
		
	}

