	/**
	 * Test whether EULA has been accepted. Otherwise display EULA.
	 * 
	 * @return True if Eula has been accepted.
	 */
	public static boolean checkEula(Activity activity) {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(activity);
		boolean accepted = sp.getBoolean(PREFERENCES_EULA_ACCEPTED, false);
		
		if (accepted) {
			Log.i(TAG, "Eula has been accepted.");
			return true;
		} else {
			Log.i(TAG, "Eula has not been accepted yet.");
			
			// Launch Eula activity
			Intent i = new Intent(activity, EulaActivity.class);
			ComponentName ci = activity.getComponentName();
			
			// Specify in intent extras which activity should be called
			// after Eula has been accepted.
			Log.d(TAG, "Local package name: " + ci.getPackageName());
			Log.d(TAG, "Local class name: " + ci.getClassName());
			i.putExtra(EXTRA_LAUNCH_ACTIVITY_PACKAGE, ci.getPackageName());
			i.putExtra(EXTRA_LAUNCH_ACTIVITY_CLASS, ci.getClassName());
			activity.startActivity(i);
			activity.finish();
			return false;
		}
	}

