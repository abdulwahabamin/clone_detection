	/**
	 * Accept EULA and proceed with main application.
	 */
	public void acceptEula() {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor e = sp.edit();
		e.putBoolean(PREFERENCES_EULA_ACCEPTED, true);
		e.commit();
		
		// Call the activity that originally called checkEula()
		Intent i = new Intent();
		i.setClassName(mLaunchPackage, mLaunchClass);
		startActivity(i);
		finish();
	}

