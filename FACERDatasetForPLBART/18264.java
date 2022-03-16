    @Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);	
		PinGMusicSongsService.mBuilder.setProgress(0, 0, false);
		PinGMusicSongsService.mBuilder.setContentText("");
		PinGMusicSongsService.mBuilder.setContentTitle(mContext.getResources().getString(R.string.done_pinning_songs));
		PinGMusicSongsService.mNotifyManager.notify(PinGMusicSongsService.notificationID, PinGMusicSongsService.mBuilder.build());
		
		//Notify the user.
		if (mApp.isFetchingPinnedSongs()==true) {
			Toast.makeText(mContext, R.string.done_pinning_songs_from_gmusic, Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(mContext, R.string.done_pinning_songs, Toast.LENGTH_LONG).show();
		}
		
		songTitlesList.clear();
		songTitlesList = null;
		songIdsList.clear();
		songIdsList = null;

		mApp.setIsFetchingPinnedSongs(false);
		
		//Stop the service.
		mContext.stopService(new Intent(mContext, PinGMusicSongsService.class));
		
	}

