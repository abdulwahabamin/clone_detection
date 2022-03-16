	@Override
	public void onPause() {
		super.onPause();

		if(amb!=null)
			amb.done();


	}

