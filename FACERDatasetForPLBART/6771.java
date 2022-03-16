	static void setDefaultPickFilePath(Context context, String path) {
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(PREFS_DEFAULTPICKFILEPATH, path);
		editor.commit();
	}

