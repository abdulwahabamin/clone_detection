	private boolean thisSlideAllowed(float dx) {
		boolean allowed = false;
		if (isMenuOpen()) {
			allowed = mViewBehind.menuOpenSlideAllowed(dx);
		} else {
			allowed = mViewBehind.menuClosedSlideAllowed(dx);
		}
		if (DEBUG)
			Log.v(TAG, "this slide allowed " + allowed + " dx: " + dx);
		return allowed;
	}

