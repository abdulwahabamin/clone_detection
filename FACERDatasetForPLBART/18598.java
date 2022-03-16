	@Override
	public void onDestroy() {
		super.onDestroy();
		
		if (CALLED_FROM_WELCOME==false) {
			getActivity().finish();
		}
		
	}

