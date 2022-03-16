	/**
	 * Sets the selector drawable.
	 *
	 * @param res a resource ID for the selector drawable
	 */
	public void setSelectorDrawable(int res) {
		mViewBehind.setSelectorBitmap(BitmapFactory.decodeResource(getResources(), res));
	}

