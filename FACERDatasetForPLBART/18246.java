    public AsyncGoogleMusicAuthenticationTask(Context context, SettingsActivity____ activity, boolean firstRun, String accountName) {
    	mContext = context;
    	mActivity = activity;
    	mAccountName = accountName;
    	mFirstRun = firstRun;
    	mFirstRunFromSettings = true;
    	
		mApp = (Common) mContext.getApplicationContext();
    }

