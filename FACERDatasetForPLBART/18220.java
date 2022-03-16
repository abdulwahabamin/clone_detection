    @Override
    protected void onPostExecute(Void arg0) {
    	super.onPostExecute(arg0);
    	
		Toast.makeText(mContext, R.string.album_art_deleted, Toast.LENGTH_LONG).show();
		
		//Update the UI.
		mApp.broadcastUpdateUICommand(new String[] {  }, new String[] {  });
		
	}

