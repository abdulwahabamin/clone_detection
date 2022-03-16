	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {

		//The initial notification will display a "Starting download" message + indeterminate progress bar.
    	mNotifyManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
    	mBuilder = new NotificationCompat.Builder(mContext);
    	mBuilder.setContentTitle(mContext.getResources().getString(R.string.starting_download));
    	mBuilder.setTicker(mContext.getResources().getString(R.string.starting_download));
    	mBuilder.setSmallIcon(R.drawable.pin_light);
    	mBuilder.setProgress(0, 0, true);
    	mNotifyManager.notify(notificationID, mBuilder.build());
        
        //Call the AsyncTask that kicks off the pinning process.
        AsyncPinSongsTask task = new AsyncPinSongsTask(mContext);
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (String[]) null);
        
        return START_STICKY;
    }

