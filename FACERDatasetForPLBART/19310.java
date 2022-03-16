		@Override
		public void onPageScrolled(final int pagerPosition, float swipeVelocity, int offsetFromCurrentPosition) {
			
			/* swipeVelocity determines whether the viewpager has finished scrolling or not.
			 * Throw in an if statement that only allows the track to change when
			 * swipeVelocity is 0 (which means the page is done scrolling). This ensures
			 * that the tracks don't jump around or get truncated while the user is 
			 * swiping between different pages.
			 */

			if (mApp.isServiceRunning() && mApp.getService().getCursor().getCount()!=1) {
				
				/* Change tracks ONLY when the user has finished the swiping gesture (swipeVelocity will be zero).
				 * Also, don't skip tracks if the new pager position is the same as the current mCursor position (indicates 
				 * that the starting and ending position of the pager is the same).
				 */
				if (swipeVelocity==0.0f && pagerPosition!=mApp.getService().getCurrentSongIndex()) {
					if (USER_SCROLL) {
                        mHandler.removeCallbacks(seekbarUpdateRunnable);
                        smoothScrollSeekbar(0);

                        mHandler.postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                mApp.getService().skipToTrack(pagerPosition);
                            }

                        }, 200);

					}

				}
				
			}
			
		}

