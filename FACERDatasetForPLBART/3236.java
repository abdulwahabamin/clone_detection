	@Override
	public void onPause() {
		super.onPause();
		if(amb!=null) {
			amb.done();
			amb.finish();
		}
		System.gc();

		//ViewManagerText.dismissPopup();
		
	}

