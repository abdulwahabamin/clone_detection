		@Override
		public void onBufferingUpdate(MediaPlayer mp, int percent) {
			
			if (mApp.getSharedPreferences().getBoolean("NOW_PLAYING_ACTIVE", false)==true) {
				
				if (mp==getCurrentMediaPlayer()) {
					float max = mp.getDuration()/1000;
					float maxDividedByHundred = max/100;
					mApp.broadcastUpdateUICommand(new String[] { Common.UPDATE_BUFFERING_PROGRESS }, 
												  new String[] { "" + (int) (percent*maxDividedByHundred) });
				}

			}
			
		}

