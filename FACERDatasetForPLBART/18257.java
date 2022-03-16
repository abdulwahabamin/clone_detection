    public AsyncPinSongsTask(Context context) {
    	
    	//Context.
    	mContext = context;
    	songIdsList = new ArrayList<String>();
    	songTitlesList = new ArrayList<String>();
    	
    	//If the cache storage directory for local copies doesn't exist, go ahead and create it.
    	File cacheFolder = null;
		try {
			cacheFolder = new File(mContext.getCacheDir().getCanonicalPath() + "/music");
	    	if (!cacheFolder.exists()) {
	    		cacheFolder.mkdirs();
	    	}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Toast.makeText(mContext, R.string.download_failed_to_initialize, Toast.LENGTH_LONG).show();
			return;
		}
    	
    	mApp = (Common) mContext.getApplicationContext();
    	try {
			mSaveLocation = cacheFolder.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

