	@Override
	public void onPause() {
		super.onPause();
		
		if (cursor!=null) {
			cursor.close();
			cursor = null;
		}
		
		getActivity().finish();
		
	}

