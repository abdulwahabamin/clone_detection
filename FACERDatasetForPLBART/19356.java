		@Override
		public void run() {
			
			try {
				
				currentProgressCountDown =  (mApp.getService().getCurrentMediaPlayer().getDuration()) - (mApp.getService().getCurrentMediaPlayer().getCurrentPosition());
				currentProgress = mApp.getService().getCurrentMediaPlayer().getCurrentPosition();
				totalDuration = mApp.getService().getCurrentMediaPlayer().getDuration();
				progressFraction = (float) currentProgress/totalDuration;
				
				if (mApp.getService().getCurrentMediaPlayer()!=null) {
					mHandler.postDelayed(progressBarRunnable, 100);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

