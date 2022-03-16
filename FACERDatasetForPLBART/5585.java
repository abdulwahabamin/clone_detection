	void startOriginalActivity() {
		// Call the activity that originally called checkEula()
		// or checkNewVersion()
		Intent i;
		if (mLaunchIntent != null) {
			i = mLaunchIntent;
			
			// Android 2.3: category LAUNCHER needs to be removed,
			// otherwise main activity is not called.
			i.removeCategory(Intent.CATEGORY_LAUNCHER);
		} else {
			i = new Intent();
			i.setClassName(mLaunchPackage, mLaunchClass);
		}
		i.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
		startActivity(i);
		finish();
	}

