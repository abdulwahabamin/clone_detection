	/**
	 * Initializes Google Analytics.
	 */
	private void initGoogleAnalytics() {
        try {
        	if (mApp.isGoogleAnalyticsEnabled()) {
        		String gaTrackingId = getResources().getString(R.string.ga_trackingId);
            	mServiceStartTime = System.currentTimeMillis();
            	
            	mGAInstance = GoogleAnalytics.getInstance(getApplicationContext());
                mTracker = mGAInstance.getTracker(gaTrackingId);
                
                mTracker.set(Fields.SESSION_CONTROL, "start");
                mTracker.send(MapBuilder.createEvent("Jams Service", 
    					 							 "Service started!", 
    					 							 "User is playing music.", 
    					 							 null).build());
        	}

        } catch (Exception e) {
        	e.printStackTrace();
        }
        
	}

