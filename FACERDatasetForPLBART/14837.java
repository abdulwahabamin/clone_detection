	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		
		case R.id.action_end:
			//close the app
			//stopService(play)
			stopService(playIntent);
			musicSRV = null;
			System.exit(0);
			break;
		
		case R.id.action_shuffle:
			musicSRV.setShuffle();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

