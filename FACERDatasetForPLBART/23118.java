	private PendingIntent buildPendingIntent() {
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		if (isMediaPlayerInit) {
			if (mMediaPlayer.isPlaying())
				intent.putExtra(MainActivity.EXTRA_FRAGMENT_ID, MainActivity.FRAGMENT_PLAY_QUEUE);
		}
		return PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
	}

