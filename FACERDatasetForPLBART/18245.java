    public AsyncGoogleMusicAuthenticationTask(Context context, boolean firstRun, String accountName) {
    	mContext = context;
    	mAccountName = accountName;
    	mFirstRun = firstRun;
    	
		mApp = (Common) mContext.getApplicationContext();
    }

