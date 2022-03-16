    private void renderTime() {
        ComponentName thisWidget = new ComponentName(mContext, WeatherAppWidget.class);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(mContext);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
        for (int i = 0; i < appWidgetIds.length; ++i) {
            int appWidgetId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.app_widget_layout);

            if (mDataDate != null && mDataDate.compareToIgnoreCase(StringUtil.getCurrentDateTime("yyyy-MM-dd")) != 0) {
                views.setTextColor(R.id.tv_app_widget_weather_desc, mContext.getApplicationContext().getResources().getColor(R.color.colorAirFour));
                views.setTextViewText(R.id.tv_app_widget_weather_desc, mContext.getApplicationContext().getString(R.string.data_out_of_date));
            }

            views.setTextViewText(R.id.tv_app_widget_time, StringUtil.getCurrentDateTime("HH:mm"));
            views.setTextViewText(R.id.tv_app_widget_dayofweek, StringUtil.getCurrentDateTime("EEEE"));
            views.setTextViewText(R.id.tv_app_widget_date, StringUtil.getCurrentDateTime("M月d日"));

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }

        renderData(mEntity);

        updateTimeSequence();
        LogUtil.e(TAG, "renderTime");
    }

