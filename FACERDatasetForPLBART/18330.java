	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    case R.id.done_blacklist_manager:
	    	AsyncBlacklistSongsTask task = new AsyncBlacklistSongsTask();
	    	task.execute();
	    	return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }

	}

