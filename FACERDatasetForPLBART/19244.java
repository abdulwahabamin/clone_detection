	@Override
	public void onPause() {
		super.onPause();
		
		if (CALLED_FROM_WELCOME==false) {
			getActivity().finish();
		}
		
	}

