	@Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		mContext = context;
        final int N = appWidgetIds.length;

        AsyncUpdateSmallWidgetTask task = new AsyncUpdateSmallWidgetTask(mContext, N, appWidgetIds, appWidgetManager);
        task.execute();
 
    }

