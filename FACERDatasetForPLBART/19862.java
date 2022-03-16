	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    	mContext = context;
        final int N = appWidgetIds.length;
        
        AsyncUpdateLargeWidgetTask task = new AsyncUpdateLargeWidgetTask(mContext, N, appWidgetIds, appWidgetManager);
        task.execute();
        
    }

