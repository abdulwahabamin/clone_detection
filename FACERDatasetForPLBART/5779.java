	/**
	 * @since 2011-09-30
	 */
	static void setShowAllWarning(Context context, boolean enabled) {
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean(PREFS_SHOWALLWARNING, enabled);
		editor.commit();
	}

