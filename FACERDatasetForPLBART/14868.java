	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@Override
	public void onPrepared(MediaPlayer mp) {
		//start the playback
		mp.start();
		
		Intent notIntent = new Intent(this, MainActivity.class);
		notIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		PendingIntent pendInt = PendingIntent.getActivity(this, 0, notIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		Notification.Builder builder = new Notification.Builder(this);
		
		builder.setContentIntent(pendInt)
			.setSmallIcon(R.drawable.play)
			.setTicker(songTitle)
			.setOngoing(true)
			.setContentTitle("Playing")
			.setContentText(songTitle);
		Notification not = builder.build();
		
		startForeground(NOTIFY_ID, not);
		
	}

