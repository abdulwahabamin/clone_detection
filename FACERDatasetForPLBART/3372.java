    private boolean hasContentProvider(Context context, String CONTENT_PROVIDER_) {
    	boolean isSuccess = false;
    	try {
	    	ContentProviderClient pc = context.getContentResolver().acquireContentProviderClient(getContentURI(CONTENT_PROVIDER_));
	    	if (pc != null) {
	    		pc.release();
	    		isSuccess = true;
	    	}
    	} catch(Exception e) {}
    	return isSuccess;
    }

