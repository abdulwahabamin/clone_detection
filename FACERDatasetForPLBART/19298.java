		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			int seekBarPosition = seekBar.getProgress();
			mApp.getService().getCurrentMediaPlayer().seekTo(seekBarPosition*1000);

            //Reinitiate the handler.
            mHandler.post(seekbarUpdateRunnable);

            //Fade out the indicator after 1000ms.
            mHandler.postDelayed(fadeOutSeekbarIndicator, 1000);
			
		}

