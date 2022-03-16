    @Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
		
		try {
			if (result==true && mApp.getService().getCurrentSong().getId().equals(mSongID)) {
				//We got the right URL, so go ahead and prepare the media player.
				mApp.getService().startPlayback();
			} else if (result==false && mApp.getService().getCurrentSong().getId().equals(mSongID)) {
				//We were unable to get the url, so skip to the next song.
				mApp.getService().skipToNextTrack();
				Toast.makeText(mContext, R.string.song_failed_to_load, Toast.LENGTH_LONG).show();
			} else {
				//The song has been changed, so the URL is now useless. Exit this AsyncTask.
				return;
			}
			
		} catch (Exception e) {
			return;
		}

	}

