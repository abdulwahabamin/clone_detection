	public static boolean isGmailClientInstalled(Context myContext) {
		  PackageManager myPackageMgr = myContext.getPackageManager();
		  try {
		    myPackageMgr.getPackageInfo("com.google.android.gm", PackageManager.GET_ACTIVITIES);
		  } catch (PackageManager.NameNotFoundException e) {
		    return (false);
		  }
		  return (true);
	}

