    @Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
		
		//Send out a broadcast that loads the new queue across the app.
		Intent intent = new Intent("com.aniruddhc.acemusic.player.NEW_SONG_UPDATE_UI");
		intent.putExtra("MESSAGE", "com.aniruddhc.acemusic.player.NEW_SONG_UPDATE_UI");
		intent.putExtra("INIT_QUEUE_DRAWER_ADAPTER", true);
		
    	//Start preparing the next song if the current song is the last track.
		if (mApp.getService().getCurrentSongIndex()==(originalPlaybackIndecesSize - 1)) {

			//Check if the service is running.
			if (mApp.isServiceRunning()) {
				mApp.getService().prepareAlternateMediaPlayer();
				
			}
			
		}
		
	}

