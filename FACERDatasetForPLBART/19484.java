		@Override
		public void run() {
			try {
				
				//Do not crossfade if the current song is set to repeat itself.
				if (getRepeatMode()!=Common.REPEAT_SONG) {
					
					//Do not crossfade if this is the last track in the queue.
					if (getCursor().getCount() > (mCurrentSongIndex+1)) {
						
						//Set the next mMediaPlayer's volume and raise it incrementally.
						if (getCurrentMediaPlayer()==getMediaPlayer()) {
							
							getMediaPlayer2().setVolume(mFadeInVolume, mFadeInVolume);
							getMediaPlayer().setVolume(mFadeOutVolume, mFadeOutVolume);
							
							//If the mMediaPlayer is already playing or it hasn't been prepared yet, we can't use crossfade.
							if (!getMediaPlayer2().isPlaying()) {
								
								if (mMediaPlayer2Prepared==true) {

									if (checkAndRequestAudioFocus()==true) {
										
										//Check if the the user requested to save the track's last playback position.
										if (getMediaPlayer2SongHelper().getSavedPosition()!=-1) {
											//Seek to the saved track position.
											getMediaPlayer2().seekTo((int) getMediaPlayer2SongHelper().getSavedPosition());
											mApp.broadcastUpdateUICommand(new String[] { Common.SHOW_AUDIOBOOK_TOAST }, 
																		  new String[] { "" + getMediaPlayer2SongHelper().getSavedPosition() });
											
										}
										
										getMediaPlayer2().start();
									} else {
										return;
									}
									
								}
								
							}
							
						} else {
							
							getMediaPlayer().setVolume(mFadeInVolume, mFadeInVolume);
							getMediaPlayer2().setVolume(mFadeOutVolume, mFadeOutVolume);
							
							//If the mMediaPlayer is already playing or it hasn't been prepared yet, we can't use crossfade.
							if (!getMediaPlayer().isPlaying()) {
								
								if (mMediaPlayerPrepared==true) {

									if (checkAndRequestAudioFocus()==true) {
										
										//Check if the the user requested to save the track's last playback position.
										if (getMediaPlayerSongHelper().getSavedPosition()!=-1) {
											//Seek to the saved track position.
											getMediaPlayer().seekTo((int) getMediaPlayerSongHelper().getSavedPosition());
											mApp.broadcastUpdateUICommand(new String[] { Common.SHOW_AUDIOBOOK_TOAST }, 
																		  new String[] { "" + getMediaPlayerSongHelper().getSavedPosition() });
											
										}
										
										getMediaPlayer().start();
									} else {
										return;
									}
									
								}
								
							}
							
						}

						mFadeInVolume = mFadeInVolume + (float) (1.0f/(((float) mCrossfadeDuration)*10.0f));
						mFadeOutVolume = mFadeOutVolume - (float) (1.0f/(((float) mCrossfadeDuration)*10.0f));

						mHandler.postDelayed(crossFadeRunnable, 100);
					}
					
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

