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
				} else if (isMediaPlayerPrepared()) {
					startMediaPlayer();
				} else {
					//Check every 100ms if mMediaPlayer is prepared.
					mHandler.post(startMediaPlayerIfPrepared);
				}
				
			} catch (IllegalStateException e) {
				//mMediaPlayer isn't prepared yet.
				mHandler.post(startMediaPlayerIfPrepared);
			}

		}

