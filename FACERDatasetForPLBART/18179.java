	public AsyncBuildLibraryTask(Context context, BuildMusicLibraryService service) {
		mContext = context;
		mApp = (Common) mContext;
        mService = service;
        mBuildLibraryProgressUpdate = new ArrayList<OnBuildLibraryProgressUpdate>();
	}

