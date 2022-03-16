	@Override
	public void onStart() {
		super.onStart();
		//GAnalytics.
		try {
			if (mApp.isGoogleAnalyticsEnabled()==true) {
				EasyTracker.getInstance(this).activityStart(this);
				
				//Get the intent that started this Activity.
			    Intent intent = this.getIntent();
			    Uri uri = intent.getData();

			    //Send a screenview using any available campaign or referrer data.
			    MapBuilder.createAppView().setAll(getReferrerMapFromUri(uri));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}

