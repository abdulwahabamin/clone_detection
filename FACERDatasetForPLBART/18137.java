    @Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
    	
    	if (mCursor!=null) {
    		mCursor.close();
        	mCursor = null;
    	}
    
	}

