	/**
	 * @since 2011-09-30
	 */
	static boolean getShowAllWarning(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getBoolean(PREFS_SHOWALLWARNING, true);
	}

