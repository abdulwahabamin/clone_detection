	private void updateNotification() {
		boolean audiobookMode = sharedPref.getBoolean("pref_audiobook_mode", false);

		// https://stackoverflow.com/questions/5528288/how-do-i-update-the-notification-text-for-a-foreground-service-in-android
		Intent resultIntent = new Intent(this, NowPlaying.class);
		// Use the FLAG_ACTIVITY_CLEAR_TOP to prevent launching a second
		// NowPlaying if one already exists.
		resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		resultIntent.putExtra("From_Notification", true);
		resultIntent.putExtra(AlbumList.ALBUM_NAME, album);
		resultIntent.putExtra(ArtistList.ARTIST_NAME, artist);
		resultIntent.putExtra(ArtistList.ARTIST_ABS_PATH_NAME, artistAbsPath);

		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		Builder builder = new NotificationCompat.Builder(
				this.getApplicationContext());
		int icon = R.drawable.ic_pgmp_launcher;
		String contentText = getResources().getString(R.string.ticker_text);
		if (songFile != null) {
			SharedPreferences prefs = getSharedPreferences(
					"PrettyGoodMusicPlayer", MODE_PRIVATE);
			prefs.edit();
			File bestGuessMusicDir = Utils.getBestGuessMusicDirectory();
			String musicRoot = prefs.getString("ARTIST_DIRECTORY",
					bestGuessMusicDir.getAbsolutePath());
			contentText = Utils.getArtistName(songFile, musicRoot) + ": "
					+ Utils.getPrettySongName(songFile);
			if (mp != null) {
				if (mp.isPlaying()) {
					icon = R.drawable.ic_pgmp_launcher;
				}
			}
		}

		Intent previousIntent = new Intent("Previous", null, this, MusicPlaybackService.class);
		previousIntent.putExtra("Message", MSG_PREVIOUS);
		PendingIntent previousPendingIntent = PendingIntent.getService(this, 0, previousIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		Intent jumpBackIntent = new Intent("JumpBack", null, this, MusicPlaybackService.class);
		jumpBackIntent.putExtra("Message", MSG_JUMPBACK);
		PendingIntent jumpBackPendingIntent = PendingIntent.getService(this, 0, jumpBackIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		Intent nextIntent = new Intent("Next", null, this, MusicPlaybackService.class);
		nextIntent.putExtra("Message", MSG_NEXT);
		PendingIntent nextPendingIntent = PendingIntent.getService(this, 0, nextIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		PendingIntent playPausePendingIntent;
		Intent playPauseIntent = new Intent("PlayPause", null, this, MusicPlaybackService.class);
		playPauseIntent.putExtra("Message", MSG_PLAYPAUSE);
		playPausePendingIntent = PendingIntent.getService(this, 0, playPauseIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		int playPauseIcon;
		if(mp != null && mp.isPlaying()){
			playPauseIcon = R.drawable.ic_action_pause;
		} else {
			playPauseIcon = R.drawable.ic_action_play;
		}

		Notification notification;
		if(audiobookMode){
			notification = builder
					.setContentText(contentText)
					.setSmallIcon(icon)
					.setWhen(System.currentTimeMillis())
					.setContentIntent(pendingIntent)
					.setContentTitle(
							getResources().getString(R.string.notification_title))
							.addAction(R.drawable.ic_action_rewind20, "", jumpBackPendingIntent)
							.addAction(playPauseIcon, "", playPausePendingIntent)
							.addAction(R.drawable.ic_action_next, "", nextPendingIntent)
							.build();
		} else {
			notification = builder
					.setContentText(contentText)
					.setSmallIcon(icon)
					.setWhen(System.currentTimeMillis())
					.setContentIntent(pendingIntent)
					.setContentTitle(
							getResources().getString(R.string.notification_title))
							.addAction(R.drawable.ic_action_previous, "", previousPendingIntent)
							.addAction(playPauseIcon, "", playPausePendingIntent)
							.addAction(R.drawable.ic_action_next, "", nextPendingIntent)
							.build();
		}

		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(uniqueid, notification);
	}

