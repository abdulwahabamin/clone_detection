		@Override
		public void onAudioFocusChange(int focusChange) {
			switch (focusChange) {
			case AudioManager.AUDIOFOCUS_GAIN:
				// If is not paused because the pause button was pressed resume.
				if (!isPausedBecauseOfButton) {
					// resume playback
					if (mMediaPlayer == null)
						// When focus is gained for first time or is lost for a
						// long time
						isMediaPlayerInit = initMediaPlayer();
					else if (!mMediaPlayer.isPlaying()) {
						// After losing focus for a short time
						mMediaPlayer.start();
						sendMusicUpdateToActivity(true, false);
						onPlaying();
					} else {
						// Back from AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK
						mMediaPlayer.setVolume(1.0f, 1.0f);
					}
				}
				break;

			case AudioManager.AUDIOFOCUS_LOSS:
				// Lost focus for an unbounded amount of time: stop playback and
				// release media player
				if (mMediaPlayer != null) {
					if (mMediaPlayer.isPlaying()) {
						mMediaPlayer.stop();
						sendMusicUpdateToActivity(true, false);
						onPause();
					}
					MusicService.this.stopForeground(true);
					mMediaPlayer.release();
					isMediaPlayerInit = false;
					mMediaPlayer = null;
				}
				break;

			case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
				// Lost focus for a short time, but we have to stop
				// playback. We don't release the media player because playback
				// is likely to resume
				if (mMediaPlayer != null) {
					if (mMediaPlayer.isPlaying()) {
						mMediaPlayer.pause();
						sendMusicUpdateToActivity(true, false);
						onPause();
					}
				}
				break;

			case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
				// Lost focus for a short time, but it's ok to keep playing
				// at an attenuated level
				if (mMediaPlayer != null) {
					if (mMediaPlayer.isPlaying())
						mMediaPlayer.setVolume(0.1f, 0.1f);
				}
				break;
			}

		}

