    @SuppressWarnings("static-access")
	@Override
    protected String doInBackground(String... params) {

		try {
			authToken = GoogleAuthUtil.getToken(mContext, mAccountName, "sj");
		} catch (GooglePlayServicesAvailabilityException e) {
			e.printStackTrace();
			availabilityExceptionStatusCode = e.getConnectionStatusCode();
			return "GOOGLE_PLAY_SERVICES_AVAILABILITY_EXCEPTION";
		} catch (UserRecoverableAuthException e) {
			e.printStackTrace();
			userRecoverableExceptionIntent = e.getIntent();
			return "USER_RECOVERABLE_AUTH_EXCEPTION";
		} catch (GoogleAuthException e) {
			e.printStackTrace();
			return "GOOGLE_AUTH_EXCEPTION";
		} catch (Exception e) {
			e.printStackTrace();
			return "GENERIC_EXCEPTION";
		}
		
		if (mFirstRun) {
			publishProgress(mContext.getResources().getString(R.string.signing_in_to_google_play_music));
		}
		
		//Login to Google Play Music using the unofficial API.
		mApp.setGMusicClientCalls(GMusicClientCalls.getInstance(mContext));
		boolean loginResult = mApp.getGMusicClientCalls().login(mContext, authToken);
		
		if (loginResult==true) {			
	    	return "AUTHENTICATED";
		} else {
	    	return "GENERIC_EXCEPTION";
		}
		
    }

