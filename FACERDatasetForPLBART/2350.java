	/**
	 * Indicates whether a specific package with minimum version code is available.
	 */
	public static boolean isPackageAvailable(final Context context, final String packageName,
			final int minVersionCode) {
		boolean result = false;
		try {
			PackageInfo pi = context.getPackageManager().getPackageInfo(
					packageName, 0);
			if (pi.versionCode >= minVersionCode) {
				result = true;
			}
	    } catch (PackageManager.NameNotFoundException e) {
	    	
	    }
	    return result;
	}

