	/** Save data from ListView when rotating the device */
    public void onSaveInstanceState(Bundle savedState) {
        super.onSaveInstanceState(savedState);
        if(mConversationArrayAdapter != null){
	        int operations = mConversationArrayAdapter.getCount();
	        if(Constants.D) Log.i(Constants.TAG,"onSaveInstanceState saving "+operations+" values");
	        
	        String[] values =  new String[operations];
	        for(int i =0 ; i < operations;i++)
	        	values[i] = mConversationArrayAdapter.getItem(i);
	        
	        savedState.putStringArray(MSG_KEY, values);
        }
    }

