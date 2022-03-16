    @Override
    public void onProgressUpdate(String... values) {
    	super.onProgressUpdate(values);
    	
    	if (DIALOG_VISIBLE==true) {
    		pd.setProgress(Integer.parseInt(values[1]));
    		pd.setMessage(values[0]);
    	}
    	
    	//Update the notification.
    	AutoFetchAlbumArtService.builder.setContentTitle(mContext.getResources().getString(R.string.downloading_missing_cover_art));
    	AutoFetchAlbumArtService.builder.setSmallIcon(R.drawable.notif_icon);
    	AutoFetchAlbumArtService.builder.setContentInfo(null);
    	AutoFetchAlbumArtService.builder.setContentText(null);
    	AutoFetchAlbumArtService.builder.setProgress(dataURIsList.size(), currentProgress, false);
    	AutoFetchAlbumArtService.notification = AutoFetchAlbumArtService.builder.build();

    	NotificationManager notifyManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
    	notifyManager.notify(AutoFetchAlbumArtService.NOTIFICATION_ID, AutoFetchAlbumArtService.notification);
    	
    }

