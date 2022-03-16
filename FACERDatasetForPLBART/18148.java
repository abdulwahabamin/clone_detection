    @Override
    protected void onPostExecute(Void arg0) {
    	Toast.makeText(mContext, 
    				   mContext.getResources().getString(R.string.equalizer_applied_to_songs_in) + " " + titleAlbum + ".", 
    				   Toast.LENGTH_SHORT).show();
		
	}

