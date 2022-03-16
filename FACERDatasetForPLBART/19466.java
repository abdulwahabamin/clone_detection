	/**
	 * Builds and returns a fully constructed Notification for devices 
	 * on Ice Cream Sandwich (APIs 14 & 15).
	 */
	private Notification buildICSNotification(SongHelper songHelper) {
		mNotificationBuilder = new NotificationCompat.Builder(mContext);
		mNotificationBuilder.setOngoing(true);
		mNotificationBuilder.setAutoCancel(false);
		mNotificationBuilder.setSmallIcon(R.drawable.notif_icon);
		
		//Open up the player screen when the user taps on the notification.
        Intent launchNowPlayingIntent = new Intent();
        launchNowPlayingIntent.setAction(AudioPlaybackService.LAUNCH_NOW_PLAYING_ACTION);
        PendingIntent launchNowPlayingPendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, launchNowPlayingIntent, 0);
        mNotificationBuilder.setContentIntent(launchNowPlayingPendingIntent);
		
        //Grab the notification layout.
		RemoteViews notificationView = new RemoteViews(mContext.getPackageName(), R.layout.notification_custom_layout);
		
		//Initialize the notification layout buttons.
    	Intent previousTrackIntent = new Intent();
    	previousTrackIntent.setAction(AudioPlaybackService.PREVIOUS_ACTION);
    	PendingIntent previousTrackPendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, previousTrackIntent, 0);
    	
    	Intent playPauseTrackIntent = new Intent();
    	playPauseTrackIntent.setAction(AudioPlaybackService.PLAY_PAUSE_ACTION);
    	PendingIntent playPauseTrackPendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, playPauseTrackIntent, 0);
    	
    	Intent nextTrackIntent = new Intent();
    	nextTrackIntent.setAction(AudioPlaybackService.NEXT_ACTION);
    	PendingIntent nextTrackPendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, nextTrackIntent, 0);
    	
    	Intent stopServiceIntent = new Intent();
    	stopServiceIntent.setAction(AudioPlaybackService.STOP_SERVICE);
    	PendingIntent stopServicePendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, stopServiceIntent, 0);
		
    	//Check if audio is playing and set the appropriate play/pause button.
    	if (mApp.getService().isPlayingMusic()) {
			notificationView.setImageViewResource(R.id.notification_base_play, R.drawable.btn_playback_pause_light);
		} else {
			notificationView.setImageViewResource(R.id.notification_base_play, R.drawable.btn_playback_play_light);
		}
    	
    	//Set the notification content.    
        notificationView.setTextViewText(R.id.notification_base_line_one, songHelper.getTitle());
        notificationView.setTextViewText(R.id.notification_base_line_two, songHelper.getArtist());
        
        //Set the states of the next/previous buttons and their pending intents.
        if (mApp.getService().isOnlySongInQueue()) {
        	//This is the only song in the queue, so disable the previous/next buttons.
        	notificationView.setViewVisibility(R.id.notification_base_next, View.INVISIBLE);
        	notificationView.setViewVisibility(R.id.notification_base_previous, View.INVISIBLE);
        	notificationView.setOnClickPendingIntent(R.id.notification_base_play, playPauseTrackPendingIntent);
        	
        } else if (mApp.getService().isFirstSongInQueue()) {
        	//This is the the first song in the queue, so disable the previous button. 
            notificationView.setViewVisibility(R.id.notification_base_previous, View.INVISIBLE);
        	notificationView.setViewVisibility(R.id.notification_base_next, View.VISIBLE);
        	notificationView.setOnClickPendingIntent(R.id.notification_base_play, playPauseTrackPendingIntent);
            notificationView.setOnClickPendingIntent(R.id.notification_base_next, nextTrackPendingIntent);
        	
        } else if (mApp.getService().isLastSongInQueue()) {
        	//This is the last song in the cursor, so disable the next button.    
            notificationView.setViewVisibility(R.id.notification_base_previous, View.VISIBLE);
        	notificationView.setViewVisibility(R.id.notification_base_next, View.INVISIBLE);
        	notificationView.setOnClickPendingIntent(R.id.notification_base_play, playPauseTrackPendingIntent);
            notificationView.setOnClickPendingIntent(R.id.notification_base_next, nextTrackPendingIntent);
        	
        } else {
        	//We're smack dab in the middle of the queue, so keep the previous and next buttons enabled.       
            notificationView.setViewVisibility(R.id.notification_base_previous,View.VISIBLE);
        	notificationView.setViewVisibility(R.id.notification_base_next, View.VISIBLE);
        	notificationView.setOnClickPendingIntent(R.id.notification_base_play, playPauseTrackPendingIntent);
            notificationView.setOnClickPendingIntent(R.id.notification_base_next, nextTrackPendingIntent);
            notificationView.setOnClickPendingIntent(R.id.notification_base_previous, previousTrackPendingIntent);
        	
        }
        
        //Set the "Stop Service" pending intent.
        notificationView.setOnClickPendingIntent(R.id.notification_base_collapse, stopServicePendingIntent);
        
        //Set the album art.
        notificationView.setImageViewBitmap(R.id.notification_base_image, songHelper.getAlbumArt());
        
        //Attach the shrunken layout to the notification.
        mNotificationBuilder.setContent(notificationView);
        
        //Build the notification object and set its flags.
        Notification notification = mNotificationBuilder.build();
        notification.flags = Notification.FLAG_FOREGROUND_SERVICE | 
				 			 Notification.FLAG_NO_CLEAR | 
				 			 Notification.FLAG_ONGOING_EVENT;
        
        return notification;
	}

