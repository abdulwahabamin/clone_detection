    @Override
    protected void onProgressUpdate(Void... v) {
    	
    	if (URL_RETRIEVED==false) {
        	Toast.makeText(mContext, R.string.album_art_not_found, Toast.LENGTH_SHORT).show();
    	} else {
    		Toast.makeText(mContext, R.string.album_art_downloaded, Toast.LENGTH_SHORT).show();
    	}
    	
    }

