    /** Save data from ListView when rotating the device 
	 * @see android.app.Activity#onRestoreInstanceState(android.os.Bundle) */
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		 if(Constants.D) Log.i(Constants.TAG,"onRestoreInstanceState restoring  values");
		// Initialize the array adapter for the conversation thread
        if (savedInstanceState != null) {
        	String[] values =  savedInstanceState.getStringArray(MSG_KEY);
        	if(mConversationArrayAdapter != null){
	            for (String msg : values) 
	            	mConversationArrayAdapter.add(msg);
	        }
        	else{
        		mConversationArrayAdapter = new CustomArrayAdapter(this, R.layout.message, values);
        	}
        }
	}

