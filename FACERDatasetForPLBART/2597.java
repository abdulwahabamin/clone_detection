	/**
	 * Test whether version code changed.
	 * 
	 * @return True if version code changed and recent changes are being shown.
	 */
	static boolean showNewVersion(Activity activity) {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(activity);
		int lastVersion = sp.getInt(PREFERENCES_VERSION_NUMBER, 0);
		int thisVersion = VersionUtils.getVersionCode(activity);
		
		if (lastVersion == thisVersion) {
			if (debug) Log.i(TAG, "Same version " + lastVersion + " as last launch.");
			return false;
		} else {
			if (debug) Log.i(TAG, "Newer version " + thisVersion + " since last launch " + lastVersion + ". Show recent changes.");
			
			startForwardActivity(activity, NewVersionActivity.class);
			return true;
		}
	}

