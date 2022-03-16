	@Override
	public int onStartCommand(Intent intent, int startId, int flags) {
		
		//Create a persistent notification that keeps this service running and displays the scan progress.
		mBuilder = new NotificationCompat.Builder(mContext);
		mBuilder.setSmallIcon(R.drawable.notif_icon);
		mBuilder.setContentTitle(getResources().getString(R.string.building_music_library));
		mBuilder.setTicker(getResources().getString(R.string.building_music_library));
		mBuilder.setContentText("");
		mBuilder.setProgress(0, 0, true);
		
		mNotifyManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotification = mBuilder.build();
		mNotification.flags |= Notification.FLAG_INSISTENT | Notification.FLAG_NO_CLEAR;
		
		startForeground(mNotificationId, mNotification);	

        //Go crazy with a full-on scan.
        AsyncBuildLibraryTask task = new AsyncBuildLibraryTask(mContext, this);
        task.setOnBuildLibraryProgressUpdate(WelcomeActivity.mBuildingLibraryProgressFragment);
        task.setOnBuildLibraryProgressUpdate(this);
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

		return START_STICKY;
	}

