    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        LogUtil.e(TAG, "onUpdate");

        startUpdateService(context);
    }

