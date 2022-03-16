	/**
	 * Opens the menu and shows the secondary (right) menu view. Will default to the regular menu
	 * if there is only one.
	 *
	 * @param animate true to animate the activity_fade, false to ignore animation
	 */
	public void showSecondaryMenu(boolean animate) {
		mViewAbove.setCurrentItem(2, animate);
	}

