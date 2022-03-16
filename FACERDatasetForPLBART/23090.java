	@Override
	protected void onSaveInstanceState(Bundle outState) {
		if (album != null)
			outState.putParcelable(EXTRA_ALBUM, album);
		outState.putShort(EXTRA_FRAGMENT_ID, currentFragment);
		super.onSaveInstanceState(outState);
	}

