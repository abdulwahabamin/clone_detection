    @Override
    protected void onProgressUpdate(Integer... values) {
    	int updateCode = values[0];
    	switch(updateCode) {
    	case 0:
    		String currentProgressText = getFormattedFileSize((long) currentDownloadedSize)
    								   + " of " 
    								   + getFormattedFileSize((long) fileSize);
    		
    		PinGMusicSongsService.mBuilder.setTicker(null);
    		PinGMusicSongsService.mBuilder.setProgress(fileSize, currentDownloadedSize, false);
    		PinGMusicSongsService.mBuilder.setContentText(currentProgressText);
    		PinGMusicSongsService.mNotifyManager.notify(PinGMusicSongsService.notificationID, PinGMusicSongsService.mBuilder.build());
    		break;
    	case 1:
    		if (i < songTitlesList.size()) {

			 	//Create the notification that displays the download progress of the song.
			 	String title = mContext.getResources().getString(R.string.downloading_no_dot) + " " + songTitlesList.get(i);
			
			 	PinGMusicSongsService.mNotifyManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
			 	PinGMusicSongsService.mBuilder = new NotificationCompat.Builder(mContext);
			 	PinGMusicSongsService.mBuilder.setContentTitle(title);
			 	PinGMusicSongsService.mBuilder.setContentText(mContext.getResources().getString(R.string.starting_download));
			 	PinGMusicSongsService.mBuilder.setSmallIcon(R.drawable.pin_light);
			 	PinGMusicSongsService.mBuilder.setProgress(0, 0, true);
			 	PinGMusicSongsService.mNotifyManager.notify(PinGMusicSongsService.notificationID, PinGMusicSongsService.mBuilder.build());
    		}
    		break;
    	case 2:
    		Toast.makeText(mContext, R.string.gmusic_app_not_installed_pin, Toast.LENGTH_SHORT).show();
    		break;
    	}

    }

