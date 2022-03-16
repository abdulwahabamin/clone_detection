    @Override
    protected void onProgressUpdate(Integer... values) {
    	super.onProgressUpdate(values);
    	switch(values[0]) {
    	case 0:
    		//Common.displayToast(R.string.playlist_created, Toast.LENGTH_SHORT);
    		Toast.makeText(mContext, R.string.playlist_modified, Toast.LENGTH_SHORT).show();
    		break;
    	case 1:
    		//Common.displayToast(R.string.playlist_could_not_be_created, Toast.LENGTH_SHORT);
    		Toast.makeText(mContext, R.string.playlist_could_not_be_modified, Toast.LENGTH_SHORT).show();
    		break;
    	}
    	
    }

