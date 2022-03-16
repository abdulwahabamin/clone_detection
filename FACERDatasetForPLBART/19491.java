		@Override
		public void run() {
			try {
				if (getCurrentMediaPlayer().isPlaying()) {
					
					if (getCurrentMediaPlayer().getCurrentPosition()>= (mRepeatSongRangePointB)) {
						getCurrentMediaPlayer().seekTo(mRepeatSongRangePointA);
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (mApp.getSharedPreferences().getInt(Common.REPEAT_MODE, Common.REPEAT_OFF)==Common.A_B_REPEAT) {
				mHandler.postDelayed(checkABRepeatRange, 100);
			}
			
		}

