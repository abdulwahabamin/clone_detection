	private void onPause() {
		isMediaPlayerPaused = true;
		playQueue.setPlaying(false);
		sendMusicUpdateToActivity(true, false);
		mNotificationManager.notify(
				NOTIFICATION_ID,
				notiBuilder.setContentIntent(buildPendingIntent())
						.setContentText(getResources().getString(R.string.paused)).getNotification());
	}

