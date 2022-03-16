    public AsyncCreateMusicLibraryTask(Activity activity,
    								   Context context, 
    								   HashSet<String> songDBIds, 
    								   String libraryName, 
    								   String libraryColorCode) {
    	mActivity = activity;
    	mContext = context;
    	mApp = (Common) context.getApplicationContext();
    	mSongDBIds = songDBIds;
    	mLibraryName = libraryName;
    	mLibraryColorCode = libraryColorCode;
    	
    }

