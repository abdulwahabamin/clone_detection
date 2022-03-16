		@Override
		public void onClick(View arg0) {

            //Remove the seekbar update runnable.
            mHandler.removeCallbacks(seekbarUpdateRunnable);

			/*
			 * Scrolling the pager will automatically call the skipToTrack() method. 
			 * Since we're passing true for the dispatchToListener parameter, the 
			 * onPageSelected() listener will receive a callback once the scrolling 
			 * animation completes. This has the side-benefit of letting the animation 
			 * finish before starting playback (keeps the animation buttery smooth).
			 */
			int newPosition = mViewPager.getCurrentItem() - 1;
			if (newPosition > -1) {
				scrollViewPager(newPosition, true, 1, true);
			} else {
				mViewPager.setCurrentItem(0, false);
			}
			
		}

