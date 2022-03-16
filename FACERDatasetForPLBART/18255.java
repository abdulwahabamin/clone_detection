    @Override
    public void onProgressUpdate(String... values) {
    	super.onProgressUpdate(values);
    	String currentFolderName = values[0];
    	
    	//Create a String template for the dialog's message body.
    	String message = mContext.getResources().getString(R.string.scanning_subfolders_message) 
    				   + " " 
    				   + mFolderName
    				   + "\n"
    				   + "\n"
    				   + currentFolderName;
    	
    	pd.setMessage(message);
    	
    }

