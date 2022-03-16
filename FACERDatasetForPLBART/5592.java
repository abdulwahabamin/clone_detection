	private static void startForwardActivity(Activity activity, Class launchClass) {
		// Launch Eula activity
		Intent forwardIntent = activity.getIntent();
		
		Intent i = new Intent(activity, launchClass);
		ComponentName ci = activity.getComponentName();
		
		// Specify in intent extras which activity should be called
		// after Eula has been accepted.
		if (debug) Log.d(TAG, "Local package name: " + ci.getPackageName());
		if (debug) Log.d(TAG, "Local class name: " + ci.getClassName());
		i.putExtra(EXTRA_LAUNCH_ACTIVITY_PACKAGE, ci.getPackageName());
		i.putExtra(EXTRA_LAUNCH_ACTIVITY_CLASS, ci.getClassName());
		if (forwardIntent != null) {
			i.putExtra(EXTRA_LAUNCH_ACTIVITY_INTENT, forwardIntent);
		}
		i.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
		activity.startActivity(i);
		activity.finish();
	}

