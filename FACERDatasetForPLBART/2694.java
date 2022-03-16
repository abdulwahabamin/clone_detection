	/**
	 * Check if no updater application is installed.
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isUpdateMenuNecessary(Context context) {
		PackageInfo pi = null;
		
		// Test for existence of all known update checker applications.
		for (int i = 0; i < UPDATE_CHECKER.length; i++) {
			try {
				pi = context.getPackageManager().getPackageInfo(
						UPDATE_CHECKER[i], 0);
			} catch (NameNotFoundException e) {
				// ignore
			}
			if (pi != null && !DEBUG_NO_MARKET) {
				// At least one kind of update checker exists,
				// so there is no need to add a menu item.
				return false;
			}
		}
		
		// If we reach this point, we add a menu item for manual update.
		return true; 
	}

