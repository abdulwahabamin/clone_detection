    @Override
    public void onDataSetChanged() {
        
        if (sharedPreferences.getBoolean("SERVICE_RUNNING", false)==true) {
        	cursor = mApp.getService().getCursor();
        }
    	
    }

