	@Override
	public void onCreate() {
		super.onCreate();
		playQueue = PlayQueue.getInstance();
		notiBuilder = new NotificationCompat.Builder(getApplicationContext()).setSmallIcon(R.drawable.ic_launcher)
				.setContentTitle(getResources().getString(R.string.app_name)).setContentIntent(buildPendingIntent())
				.setContentText(getResources().getString(R.string.tap_to_play));
		mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		isMediaPlayerInit = initMediaPlayer();
		startCpuProfilerService();
	}

