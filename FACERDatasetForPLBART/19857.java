	@Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		mContext = context;
        final int N = appWidgetIds.length;

        AsyncUpdateBlurredWidgetTask task = new AsyncUpdateBlurredWidgetTask(mContext, N, appWidgetIds, appWidgetManager);
        task.execute();
 
    }

