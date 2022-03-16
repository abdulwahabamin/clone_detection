		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			mHandler.removeCallbacks(seekbarUpdateRunnable);
            mHandler.removeCallbacks(fadeOutSeekbarIndicator);

            mSeekbarIndicatorLayoutParent.setVisibility(View.VISIBLE);
            mSeekbarIndicatorLayout.setAlpha(0.8f);

		}

