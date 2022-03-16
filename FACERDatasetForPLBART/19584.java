    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews rv = new RemoteViews(mContext.getPackageName(), R.layout.large_widget_listview_layout);
        if (position <= getCount()) {
        	
        	try {
        		if (mApp.getService().getPlaybackIndecesList()!=null && mApp.getService().getPlaybackIndecesList().size()!=0) {
            		if (cursor.getCount() > mApp.getService().getPlaybackIndecesList().get(position)) {
                		cursor.moveToPosition(mApp.getService().getPlaybackIndecesList().get(position));
                	} else {
                		return null;
                	}
            		
            	} else {
            		return null;
            	}
        	} catch (Exception e) {
        		return null;
        	}
        	
        	//Set the song title, album, and artist fields.
        	String songTitle = cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_TITLE));
        	String songAlbumArtPath = cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ALBUM_ART_PATH));
        	ImageSize imageSize = new ImageSize(100, 100);
        	
            //Set the duration of the song.
            long songDurationInMillis = 0;
            try {
            	songDurationInMillis = Long.parseLong(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_DURATION)));
            } catch (Exception e) {
            	songDurationInMillis = 0;
            }
        	
        	rv.setTextViewText(R.id.widget_listview_song_name, songTitle);
            rv.setTextViewText(R.id.widget_listview_duration, convertMillisToMinsSecs(songDurationInMillis));
            
            if (mWidgetColor.equals("LIGHT")) {
    			rv.setTextColor(R.id.widget_listview_song_name, Color.BLACK);
    			rv.setTextColor(R.id.widget_listview_duration, Color.BLACK);
    		}
            
            Bitmap bitmap = mApp.getImageLoader().loadImageSync(songAlbumArtPath, imageSize, displayImageOptions);
            rv.setImageViewBitmap(R.id.widget_listview_thumbnail, bitmap);
            
        }
        
        /* This intent latches itself onto the pendingIntentTemplate from 
         * LargeWidgetProvider.java and adds the extra "INDEX" argument to it. */
        Intent fillInIntent = new Intent();
        fillInIntent.putExtra("INDEX", position);
        rv.setOnClickFillInIntent(R.id.widget_listview_layout, fillInIntent);
        
        return rv;
    }

