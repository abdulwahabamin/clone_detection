		@Override
		public void onPrepared(MediaPlayer mediaPlayer) {
			
			//Update the prepared flag.
			setIsMediaPlayer2Prepared(true);
			
			//Set the completion listener for mMediaPlayer2.
			getMediaPlayer2().setOnCompletionListener(onMediaPlayer2Completed);

			//Check to make sure we have AudioFocus.
			if (checkAndRequestAudioFocus()==true) {
				
				//Check if the the user saved the track's last playback position.
				if (getMediaPlayer2SongHelper().getSavedPosition()!=-1) {
					//Seek to the saved track position.
					mMediaPlayer2.seekTo((int) getMediaPlayer2SongHelper().getSavedPosition());
					mApp.broadcastUpdateUICommand(new String[] { Common.SHOW_AUDIOBOOK_TOAST }, 
												  new String[] { "" + getMediaPlayer2SongHelper().getSavedPosition() });

				}
				
			} else {
				return;
			}
			
		}

