	@Override
	protected void onResume( ){
		super.onResume();
		if(paused){
			setController();
			paused = false;
		}
	}

