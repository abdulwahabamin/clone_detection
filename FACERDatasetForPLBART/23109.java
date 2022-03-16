	private void onPlaying() {
		isMediaPlayerPaused = false;
		isPausedBecauseOfButton = false;
		playQueue.setPlaying(true);
		mNotificationManager.notify(
				NOTIFICATION_ID,
				notiBuilder
						.setContentIntent(buildPendingIntent())
						.setContentText(
								getResources().getString(R.string.playing) + " " + playQueue.getCurrent().getTitle())
						.getNotification());
	}

