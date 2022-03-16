	/**
	 * Updates all open homescreen/lockscreen widgets.
	 */
	public void updateWidgets() {
		try {
			//Fire a broadcast message to the widget(s) to update them.
			Intent smallWidgetIntent = new Intent(mContext, SmallWidgetProvider.class);
			smallWidgetIntent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
			int smallWidgetIds[] = AppWidgetManager.getInstance(mContext).getAppWidgetIds(new ComponentName(mContext, SmallWidgetProvider.class));
			smallWidgetIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, smallWidgetIds);
			mContext.sendBroadcast(smallWidgetIntent);
			
			Intent largeWidgetIntent = new Intent(mContext, LargeWidgetProvider.class);
			largeWidgetIntent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
			int largeWidgetIds[] = AppWidgetManager.getInstance(mContext).getAppWidgetIds(new ComponentName(mContext, LargeWidgetProvider.class));
			largeWidgetIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, largeWidgetIds);
			mContext.sendBroadcast(largeWidgetIntent);
			
			Intent blurredWidgetIntent = new Intent(mContext, BlurredWidgetProvider.class);
			blurredWidgetIntent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
			int blurredWidgetIds[] = AppWidgetManager.getInstance(mContext).getAppWidgetIds(new ComponentName(mContext, BlurredWidgetProvider.class));
			blurredWidgetIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, blurredWidgetIds);
			mContext.sendBroadcast(blurredWidgetIntent);
			
			Intent albumArtWidgetIntent = new Intent(mContext, AlbumArtWidgetProvider.class);
			albumArtWidgetIntent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
			int albumArtWidgetIds[] = AppWidgetManager.getInstance(mContext).getAppWidgetIds(new ComponentName(mContext, AlbumArtWidgetProvider.class));
			albumArtWidgetIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, albumArtWidgetIds);
			mContext.sendBroadcast(albumArtWidgetIntent);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

