	/**
	 * Test whether EULA has been accepted. Otherwise display EULA.
	 * 
	 * @return True if Eula needs to be shown.
	 */
	static boolean showEula(Activity activity) {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(activity);
		boolean accepted = sp.getBoolean(PREFERENCES_EULA_ACCEPTED, false);
		
		if (accepted) {
			if (debug) Log.d(TAG, "Eula has been accepted.");
			return false;
		} else {
			if (debug) Log.d(TAG, "Eula has not been accepted yet.");
			
			startForwardActivity(activity, EulaActivity.class);
			return true;
		}
	}

