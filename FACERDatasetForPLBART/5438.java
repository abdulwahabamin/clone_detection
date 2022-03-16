	/**
	 * Adds a menu item for update only if update checker is not installed.
	 * 
	 * @param context
	 * @param menu
	 * @param groupId
	 * @param itemId
	 * @param order
	 * @param titleRes
	 * @return
	 */
	public static MenuItem addUpdateMenu(Context context, Menu menu, int groupId,
			int itemId, int order, int titleRes) {
		PackageInfo pi = null;

		// Test for existence of all known update checker applications.
		for (int i = 0; i < UPDATE_CHECKER.length; i++) {
			try {
				pi = context.getPackageManager().getPackageInfo(
						UPDATE_CHECKER[i], 0);
			} catch (NameNotFoundException e) {
				// ignore
			}
			if (pi != null) {
				// At least one kind of update checker exists,
				// so there is no need to add a menu item.
				return null;
			}
		}

		// If we reach this point, we add a menu item for manual update.
		return menu.add(groupId, itemId, order, titleRes).setIcon(
				android.R.drawable.ic_menu_info_details).setShortcut('9',
				'u');
	}

