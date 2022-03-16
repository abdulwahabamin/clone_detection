		@Override
		public void onCompletion(MediaPlayer mp) {
			
			//Remove the crossfade playback.
            mHandler.removeCallbacks(startCrossFadeRunnable);
			mHandler.removeCallbacks(crossFadeRunnable);
			
			//Set the track position handler (notifies the handler when the track should start being faded).
			if (mHandler!=null && mApp.isCrossfadeEnabled()) {
				mHandler.post(startCrossFadeRunnable);
			}

			//Reset the fadeVolume variables.
			mFadeInVolume = 0.0f;
			mFadeOutVolume = 1.0f;
			
			//Reset the volumes for both mediaPlayers.
			getMediaPlayer().setVolume(1.0f, 1.0f);
			getMediaPlayer2().setVolume(1.0f, 1.0f);

			try {
				if (isAtEndOfQueue() && getRepeatMode()!=Common.REPEAT_PLAYLIST) {
					stopSelf();
				} else if (isMediaPlayer2Prepared()) {
					startMediaPlayer2();
				} else {
					//Check every 100ms if mMediaPlayer2 is prepared.
					mHandler.post(startMediaPlayer2IfPrepared);
				}
				
			} catch (IllegalStateException e) {
				//mMediaPlayer2 isn't prepared yet.
				mHandler.post(startMediaPlayer2IfPrepared);
			}

		}

