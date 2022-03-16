		public void onAudioFocusChange(int focusChange) {
			Log.w(TAG, "Focus change received " + focusChange);
			if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
				Log.i(TAG, "AUDIOFOCUS_LOSS_TRANSIENT");
				if (mp.isPlaying()) {
					stateOnFocusLoss = PlaybackState.PLAYING;
				} else {
					stateOnFocusLoss = PlaybackState.PAUSED;
				}
				pause();
				MusicPlaybackService.this.audioFocusLossTime = System
						.currentTimeMillis();
				// Pause playback
			} else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
				Log.i(TAG, "AUDIOFOCUS_GAIN");
				// If it's been less than 20 seconds, resume playback
				long curr = System.currentTimeMillis();
				if (((curr - MusicPlaybackService.this.audioFocusLossTime) < 30000)
						&& stateOnFocusLoss == PlaybackState.PLAYING) {
					play();
				} else {
					Log.i(TAG,
							"It's been more than 30 seconds or we were paused, don't auto-play");
				}
			} else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
				Log.i(TAG, "AUDIOFOCUS_LOSS");
				if (mp.isPlaying()) {
					stateOnFocusLoss = PlaybackState.PLAYING;
				} else {
					stateOnFocusLoss = PlaybackState.PAUSED;
				}
				pause();
				MusicPlaybackService.this.audioFocusLossTime = System
						.currentTimeMillis();
				// Stop playback
			} else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
				Log.i(TAG, "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
				MusicPlaybackService.this.audioFocusLossTime = System
						.currentTimeMillis();
				if (mp.isPlaying()) {
					stateOnFocusLoss = PlaybackState.PLAYING;
				} else {
					stateOnFocusLoss = PlaybackState.PAUSED;
				}
				pause();
			} else if (focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK) {
				Log.i(TAG, "AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK");
				long curr = System.currentTimeMillis();
				if (((curr - MusicPlaybackService.this.audioFocusLossTime) < 30000)
						&& stateOnFocusLoss == PlaybackState.PLAYING) {
					play();
				} else {
					Log.i(TAG,
							"It's been more than 30 seconds or we were paused, don't auto-play");
				}
			}
		}

