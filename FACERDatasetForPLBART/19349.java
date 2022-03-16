    @Override
    public void onPause() {
    	super.onPause();
    	
    	//Kill the activity to free up memory. We can restart the activity later.
    	finish();
    	
    }

