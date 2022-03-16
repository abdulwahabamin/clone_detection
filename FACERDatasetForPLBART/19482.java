		@Override
		public void run() {
			if (isMediaPlayer2Prepared())
				startMediaPlayer2();
			else
				mHandler.postDelayed(this, 100);
			
			
		}

