    protected void onPreExecute() {
    	super.onPreExecute();
    	
    	//The initial notification will display a "Starting download" message + indeterminate progress bar.
    	PinGMusicSongsService.mBuilder.setContentTitle(mContext.getResources().getString(R.string.starting_download));
    	PinGMusicSongsService.mBuilder.setTicker(mContext.getResources().getString(R.string.starting_download));
    	PinGMusicSongsService.mBuilder.setSmallIcon(R.drawable.pin_light);
    	PinGMusicSongsService.mBuilder.setProgress(0, 0, true);
    	
    	PinGMusicSongsService.mNotifyManager.notify(PinGMusicSongsService.notificationID, 
    											    PinGMusicSongsService.mBuilder.build());
    }

