    public AsyncGoogleMusicAuthenticationTask(Context context, FragmentActivity activity, boolean firstRun, String accountName) {
    	mContext = context;
    	mActivity = activity;
    	mAccountName = accountName;
    	mFirstRun = firstRun;
    	
		mApp = (Common) mContext.getApplicationContext();
    }

