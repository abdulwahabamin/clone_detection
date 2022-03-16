    public AsyncUpdateLargeWidgetTask(Context context, int numWidgets, int appWidgetIds[], AppWidgetManager appWidgetManager) {
    	mContext = context;
    	mApp = (Common) mContext.getApplicationContext();
    	mAppWidgetIds = appWidgetIds;
    	mAppWidgetManager = appWidgetManager;
    	mNumWidgets = numWidgets;
    }

