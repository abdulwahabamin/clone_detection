	@Override
	public void onServiceFailed(Exception exception) {
		//Can't move forward from this point.
		exception.printStackTrace();
		Toast.makeText(mContext, R.string.unable_to_start_playback, Toast.LENGTH_SHORT).show();
		
	}

