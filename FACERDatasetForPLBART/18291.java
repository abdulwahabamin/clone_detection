    public AsyncUpdateBlurredWidgetTask(Context context, int numWidgets, int appWidgetIds[], AppWidgetManager appWidgetManager) {
    	mContext = context;
    	mApp = (Common) mContext.getApplicationContext();
    	sharedPreferences = mContext.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
    	mAppWidgetIds = appWidgetIds;
    	mAppWidgetManager = appWidgetManager;
    	mNumWidgets = numWidgets;
    }

