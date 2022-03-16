	/**
	 * Get application icon.
	 * 
	 * Since API level 4 this routine could be replaced by
	 * icon = getApplicationInfo().icon;
	 * 
	 * @return
	 */
	public static int getApplicationIcon(Context context) {
		int icon = 0;
		try {
			PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			icon = pi.applicationInfo.icon;
		} catch (PackageManager.NameNotFoundException e) {
			Log.e(TAG, "Package name not found", e);
		};
		return icon;
	}

