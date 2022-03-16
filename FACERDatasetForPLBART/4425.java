	public static boolean isInstagramInstalled(Context myContext) {
		  PackageManager myPackageMgr = myContext.getPackageManager();
		  try {
		    myPackageMgr.getPackageInfo("com.instagram.android", PackageManager.GET_ACTIVITIES);
		  } catch (PackageManager.NameNotFoundException e) {
		    return (false);
		  }
		  return (true);
	}

