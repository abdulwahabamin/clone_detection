	@Override
	public void onDestroyView() {
		super.onDestroyView();

		if (isRemoving()) {
			mCursor.close();
			mCursor = null;
		}
		
	}

