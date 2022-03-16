		@Override
		public void run() {

			//Check if we're in the last part of the current song.
			try {
				if (getCurrentMediaPlayer().isPlaying()) {

					int currentTrackDuration = getCurrentMediaPlayer().getDuration();
					int currentTrackFadePosition = currentTrackDuration - (mCrossfadeDuration*1000);
					if (getCurrentMediaPlayer().getCurrentPosition() >= currentTrackFadePosition) {
						//Launch the next runnable that will handle the cross fade effect.
						mHandler.postDelayed(crossFadeRunnable, 100);

					} else {
						mHandler.postDelayed(startCrossFadeRunnable, 1000);
					}

				} else {
					mHandler.postDelayed(startCrossFadeRunnable, 1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

