		@Override
		public void onPrepared(MediaPlayer mediaPlayer) {
			
			//Update the prepared flag.
			setIsMediaPlayerPrepared(true);
			
			//Set the completion listener for mMediaPlayer.
			getMediaPlayer().setOnCompletionListener(onMediaPlayerCompleted);

			//Check to make sure we have AudioFocus.
			if (checkAndRequestAudioFocus()==true) {
				
				//Check if the the user saved the track's last playback position.
				if (getMediaPlayerSongHelper().getSavedPosition()!=-1) {
					//Seek to the saved track position.
					mMediaPlayer.seekTo((int) getMediaPlayerSongHelper().getSavedPosition());
					mApp.broadcastUpdateUICommand(new String[] { Common.SHOW_AUDIOBOOK_TOAST }, 
												  new String[] { "" + getMediaPlayerSongHelper().getSavedPosition() });

				}
				
				//This is the first time mMediaPlayer has been prepared, so start it immediately.
				if (mFirstRun) {
					startMediaPlayer();
					mFirstRun = false;
				}
				
			} else {
				return;
			}

		}

