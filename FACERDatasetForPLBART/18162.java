    @Override
    protected void onPostExecute(Void params) {
	   	Toast.makeText(mContext, 
	 				   mContext.getResources().getString(R.string.equalizer_applied_to_songs_in) + " " + titleGenre + ".", 
	 				   Toast.LENGTH_SHORT).show();

	}

