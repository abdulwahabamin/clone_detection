	/**
	 * after user clicking the menu, the method will be called
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, UPDATE, 1, R.string.mp3list_update);
		menu.add(0, ABOUT, 2, R.string.mp3list_about);

		return super.onCreateOptionsMenu(menu);
	}

