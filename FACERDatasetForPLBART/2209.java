	static void storeCurrentVersionCode(Context context) {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
		int thisVersion = VersionUtils.getVersionCode(context);
		SharedPreferences.Editor e = sp.edit();
		e.putInt(PREFERENCES_VERSION_NUMBER, thisVersion);
		e.commit();
	}

