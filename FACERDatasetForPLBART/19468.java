	/**
	 * Updates the current notification with info from the specified 
	 * SongHelper object.
	 */
	public void updateNotification(SongHelper songHelper) {
		Notification notification = null;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			notification = buildJBNotification(songHelper);
		else
			notification = buildICSNotification(songHelper);
		
		//Update the current notification.
		NotificationManager notifManager = (NotificationManager) mApp.getSystemService(Context.NOTIFICATION_SERVICE);
		notifManager.notify(mNotificationId, notification);
		
	}

