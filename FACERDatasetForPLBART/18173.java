    @Override
    protected void onPostExecute(Void arg0) {
		
    	Intent intent = new Intent(mContext, AutoFetchAlbumArtService.class);
    	mContext.stopService(intent);
    	
    	if (pd.isShowing() && DIALOG_VISIBLE==true) {
    		pd.dismiss();
    	}
    	
    	//Dismiss the notification.
    	AutoFetchAlbumArtService.builder.setTicker(mContext.getResources().getString(R.string.done_downloading_art));
    	AutoFetchAlbumArtService.builder.setContentTitle(mContext.getResources().getString(R.string.done_downloading_art));
    	AutoFetchAlbumArtService.builder.setSmallIcon(R.drawable.notif_icon);
    	AutoFetchAlbumArtService.builder.setContentInfo(null);
    	AutoFetchAlbumArtService.builder.setContentText(null);
    	AutoFetchAlbumArtService.builder.setProgress(0, 0, false);
    	AutoFetchAlbumArtService.notification = AutoFetchAlbumArtService.builder.build();
    	AutoFetchAlbumArtService.notification.flags = Notification.FLAG_AUTO_CANCEL;

    	NotificationManager notifyManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
    	notifyManager.notify(AutoFetchAlbumArtService.NOTIFICATION_ID, AutoFetchAlbumArtService.notification);
    	
    	Toast.makeText(mContext, R.string.done_downloading_art, Toast.LENGTH_LONG).show();
    	
    	//Rescan for album art.
		//Seting the "RESCAN_ALBUM_ART" flag to true will force MainActivity to rescan the folders.
		sharedPreferences.edit().putBoolean("RESCAN_ALBUM_ART", true).commit();
		
		//Restart the app.
		final Intent i = mActivity.getBaseContext()
				                  .getPackageManager()
				                  .getLaunchIntentForPackage(mActivity.getBaseContext().getPackageName());
		
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		mActivity.startActivity(i);
		mActivity.finish();
    	
    }

