		@Override
	    public void onReceive(Context context, Intent intent) {
			if (intent.hasExtra(Common.UPDATE_EQ_FRAGMENT)) {
				new AsyncInitSlidersTask().execute();
				
			}

            if (intent.hasExtra(Common.SERVICE_STOPPING)) {
                finish();
            }
			
		}

