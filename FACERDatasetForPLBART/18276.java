    @Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);	
		Toast.makeText(mContext, R.string.pinned_songs_removed, Toast.LENGTH_SHORT).show();
		
	}

