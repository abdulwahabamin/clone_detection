	private void updateWidget() {
		try {
			Intent largeWidgetIntent = new Intent(this, LargeWidgetProvider.class);
			largeWidgetIntent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
			int largeWidgetIds[] = AppWidgetManager.getInstance(this).getAppWidgetIds(new ComponentName(this, LargeWidgetProvider.class));
			largeWidgetIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, largeWidgetIds);
			this.sendBroadcast(largeWidgetIntent);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

