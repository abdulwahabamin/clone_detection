    @SuppressLint("NewApi")
	@Override
    protected Boolean doInBackground(String... params) {

    	//Perform this loop procedure for each App Widget that belongs to this mApp
        for (int i=0; i < mNumWidgets; i++) {
            currentAppWidgetId = mAppWidgetIds[i];
            
            Intent playPauseIntent = new Intent();
        	playPauseIntent.setAction(PLAY_PAUSE_ACTION);
        	PendingIntent playPausePendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, playPauseIntent, 0);
        	
        	Intent nextIntent = new Intent();
        	nextIntent.setAction(NEXT_ACTION);
        	PendingIntent nextPendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, nextIntent, 0);
        	
        	Intent previousIntent = new Intent();
        	previousIntent.setAction(PREVIOUS_ACTION);
        	PendingIntent previousPendingIntent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, previousIntent, 0);

            //Get the layout of the widget and attach a click listener to each element.
            RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.blurred_widget_layout);
            views.setOnClickPendingIntent(R.id.widget_play, playPausePendingIntent);
            views.setOnClickPendingIntent(R.id.widget_previous_track, previousPendingIntent);
            views.setOnClickPendingIntent(R.id.widget_next_track, nextPendingIntent);
            
            //Get the downsampled image of the current song's album art.
            views.setImageViewBitmap(R.id.widget_album_art, getAlbumArt());
            views.setTextViewText(R.id.widget_song_title_text, mApp.getService().getCurrentSong().getTitle());
            views.setTextViewText(R.id.widget_artist_album_text, mApp.getService().getCurrentSong().getAlbum() 
            												   + mApp.getService().getCurrentSong().getArtist());

            if (mApp.isServiceRunning()) {
            	
            	try {
                	if (mApp.getService().getCurrentMediaPlayer().isPlaying()) {
                		views.setImageViewResource(R.id.widget_play, R.drawable.btn_playback_pause_light);
                	} else {
                		views.setImageViewResource(R.id.widget_play, R.drawable.btn_playback_play_light);
                	}
            	} catch (Exception e) {
            		// TODO Auto-generated method stub
            		e.printStackTrace();
            	}
            	
            }
            
            //Tapping the album art should open up the app's NowPlayingActivity.
            if (mApp.isServiceRunning()) {
            	final Intent notificationIntent = new Intent(mContext, NowPlayingActivity.class);
                notificationIntent.putExtra("CALLED_FROM_FOOTER", true);
                notificationIntent.putExtra("CALLED_FROM_NOTIF", true);
                
                PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, notificationIntent, 0);
                views.setOnClickPendingIntent(R.id.app_widget_small_image, pendingIntent);
                
            }

            //Tell the AppWidgetManager to perform an update on the current app widget\
            try {
            	mAppWidgetManager.updateAppWidget(currentAppWidgetId, views);
            } catch (Exception e) {
            	continue;
            }
            
        }
    	
    	return true;
    }

