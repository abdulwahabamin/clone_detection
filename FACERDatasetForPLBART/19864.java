	private void updateWidgetConfig() {
		AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
		RemoteViews views = new RemoteViews(getPackageName(),
											R.layout.small_widget_layout);
											appWidgetManager.updateAppWidget(mAppWidgetId, views);
											
		Intent resultValue = new Intent();
		resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
		setResult(RESULT_OK, resultValue);
		updateWidget();
		finish();
	}

