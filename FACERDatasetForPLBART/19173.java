		@Override
		public void run() {
			
			if (mApp.isBuildingLibrary()==false) {
				launchMainActivity();
			} else {
				mHandler.postDelayed(this, 100);
			}

		}

