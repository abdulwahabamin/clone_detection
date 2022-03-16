    @SuppressLint("NewApi")
	@Override
    protected Boolean doInBackground(String... params) {

    	//Perform this loop procedure for each App Widget that belongs to this mApp
        for (int i=0; i < mNumWidgets; i++) {
            currentAppWidgetId = mAppWidgetIds[i];
            String widgetColor = mApp.getSharedPreferences().getString("" + currentAppWidgetId, "DARK");
            views = new RemoteViews(mContext.getPackageName(), R.layout.small_widget_layout);
            
            if (widgetColor.equals("DARK")) {
            	views.setInt(R.id.small_widget_parent_layout, "setBackgroundResource", R.drawable.appwidget_dark_bg);
            	views.setImageViewResource(R.id.app_widget_small_previous, R.drawable.btn_playback_previous_light);
            	views.setImageViewResource(R.id.app_widget_small_next, R.drawable.btn_playback_next_light);
            } else if (widgetColor.equals("LIGHT")) {
            	views.setInt(R.id.small_widget_parent_layout, "setBackgroundResource", R.drawable.appwidget_bg);
            	views.setImageViewResource(R.id.app_widget_small_previous, R.drawable.btn_playback_previous);
            	views.setImageViewResource(R.id.app_widget_small_next, R.drawable.btn_playback_next);
            }
            
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
            views.setOnClickPendingIntent(R.id.app_widget_small_play, playPausePendingIntent);
            views.setOnClickPendingIntent(R.id.app_widget_small_previous, previousPendingIntent);
            views.setOnClickPendingIntent(R.id.app_widget_small_next, nextPendingIntent);
            
            //Get the downsampled image of the current song's album art.
            views.setImageViewBitmap(R.id.app_widget_small_image, getAlbumArt());
            
            if (mApp.isServiceRunning()) {
            	
            	final Intent notificationIntent = new Intent(mContext, NowPlayingActivity.class);
                notificationIntent.putExtra("CALLED_FROM_FOOTER", true);
                notificationIntent.putExtra("CALLED_FROM_NOTIF", true);
                
                PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, notificationIntent, 0);
                views.setOnClickPendingIntent(R.id.app_widget_small_image, pendingIntent);
            	
            } else {
            	views.setImageViewResource(R.id.app_widget_small_image, R.drawable.default_album_art);
            	
            	if (widgetColor.equals("DARK")) {
        			views.setImageViewResource(R.id.app_widget_small_play, R.drawable.btn_playback_play_light);
        		} else if (widgetColor.equals("LIGHT")) {
        			views.setImageViewResource(R.id.app_widget_small_play, R.drawable.btn_playback_play);
        		}
            	
            	final Intent intent = new Intent(mContext, LauncherActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent, 0);
                views.setOnClickPendingIntent(R.id.app_widget_small_image, pendingIntent);
            	
            }
            
            views.setTextViewText(R.id.app_widget_small_line_one, mApp.getService().getCurrentSong().getTitle());
            views.setTextViewText(R.id.app_widget_small_line_two, mApp.getService().getCurrentSong().getAlbum() + 
            													  mApp.getService().getCurrentSong().getArtist());

            if (widgetColor.equals("LIGHT")) {
    			views.setTextColor(R.id.app_widget_small_line_one, Color.BLACK);
    			views.setTextColor(R.id.app_widget_small_line_two, Color.BLACK);
    		}
            
            if (mApp.isServiceRunning()) {
            	
            	try {
            		if (mApp.getService().getCurrentMediaPlayer().isPlaying()) {
                		if (widgetColor.equals("DARK")) {
                			views.setImageViewResource(R.id.app_widget_small_play, R.drawable.btn_playback_pause_light);
                		} else if (widgetColor.equals("LIGHT")) {
                			views.setImageViewResource(R.id.app_widget_small_play, R.drawable.btn_playback_pause);
                		}
                		
                	} else {
                		if (widgetColor.equals("DARK")) {
                			views.setImageViewResource(R.id.app_widget_small_play, R.drawable.btn_playback_play_light);
                		} else if (widgetColor.equals("LIGHT")) {
                			views.setImageViewResource(R.id.app_widget_small_play, R.drawable.btn_playback_play);
                		}
                		
                	}
            	} catch (Exception e) {
            		// TODO Auto-generated method stub
            		e.printStackTrace();
            	}
            	
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

