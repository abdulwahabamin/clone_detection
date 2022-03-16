    public AsyncAutoGetAlbumArtTask(Context context, Activity activity) {
    	mContext = context;
        mApp = (Common) context.getApplicationContext();
    	mActivity = activity;
    	sharedPreferences = mContext.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
    	task = this;
    	dbHelper = new DBAccessHelper(mContext);
    }

