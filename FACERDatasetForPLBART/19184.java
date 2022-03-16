	@Override
	public void onStop() {
		super.onStop();
		//GAnalytics.
		try {
			if (mApp.isGoogleAnalyticsEnabled()==true) {
				EasyTracker.getInstance(this).activityStop(this);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

