	private void updateWidget() {
		try {
			Intent smallWidgetIntent = new Intent(this, SmallWidgetProvider.class);
			smallWidgetIntent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
			int smallWidgetIds[] = AppWidgetManager.getInstance(this).getAppWidgetIds(new ComponentName(this, SmallWidgetProvider.class));
			smallWidgetIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, smallWidgetIds);
			this.sendBroadcast(smallWidgetIntent);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

