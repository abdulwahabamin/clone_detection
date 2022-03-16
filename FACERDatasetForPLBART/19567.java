	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {

		//Launch a notification to set the service as a foreground service.
		builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle(getResources().getString(R.string.downloading_missing_cover_art));
        builder.setTicker(getResources().getString(R.string.downloading_missing_cover_art));
        builder.setContentText(null);
        
        notification = builder.build();
        notification.flags |= Notification.FLAG_FOREGROUND_SERVICE;
        notification.flags |= Notification.FLAG_NO_CLEAR;
        notification.flags |= Notification.FLAG_ONGOING_EVENT;

        startForeground(NOTIFICATION_ID, notification);
		
        //Call the AsyncTask that checks for missing art and downloads them.
        AsyncAutoGetAlbumArtTask task = new AsyncAutoGetAlbumArtTask(mContext, SettingsActivity____.mSettingsActivity);
        task.execute();
        
        return START_STICKY;
    }

