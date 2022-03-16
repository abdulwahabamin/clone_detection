    @Override
    protected void onPostExecute(Boolean successStatus) {
    	pd.dismiss();
    	
    	if (successStatus==true) {
        	Toast.makeText(mContext, 
		 				   mContext.getResources().getString(R.string.equalizer_applied_to_songs_in) + " " + titlePlaylist + ".", 
		 				   Toast.LENGTH_LONG).show();
    	} else {
        	Toast.makeText(mContext, R.string.error_occurred, Toast.LENGTH_LONG).show();
    	}
		
	}

