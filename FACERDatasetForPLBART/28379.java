	/**
	 * Sets the behind offset.
	 *
	 * @param i The margin, in pixels, on the right of the screen that the behind view scrolls to.
	 */
	public void setBehindOffset(int i) {
		//		RelativeLayout.LayoutParams params = ((RelativeLayout.LayoutParams)mViewBehind.getLayoutParams());
		//		int bottom = params.bottomMargin;
		//		int top = params.topMargin;
		//		int left = params.leftMargin;
		//		params.setMargins(left, top, i, bottom);
		mViewBehind.setWidthOffset(i);
	}

