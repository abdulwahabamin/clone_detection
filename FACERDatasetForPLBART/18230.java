    @Override
    protected void onPostExecute(Integer result) {
	    dataURIsList.clear();

	    if (result==0) {
	    	//Update the UI.
	    	mApp.broadcastUpdateUICommand(new String[] { }, new String[] { });
		    Toast.makeText(mContext, R.string.album_art_downloaded, Toast.LENGTH_SHORT).show();
	    } else {
	    	Toast.makeText(mContext, R.string.unable_to_get_album_art, Toast.LENGTH_SHORT).show();
	    }
	    
	}

