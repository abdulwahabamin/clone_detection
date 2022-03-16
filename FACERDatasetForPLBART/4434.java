	public static boolean isNaverLineClientInstalled(Context myContext) {
		  PackageManager myPackageMgr = myContext.getPackageManager();
		  try {
		    myPackageMgr.getPackageInfo("jp.naver.line.android", PackageManager.GET_ACTIVITIES);
		    /*
		    FeatureInfo[] feat=myPackageMgr.getSystemAvailableFeatures();
		    if(feat!=null) {
		    	for(FeatureInfo f: feat) {
		    		BLog.e("LINE", ""+f.name);
		    	}
		    }
		    */
		  } catch (PackageManager.NameNotFoundException e) {
		    return (false);
		  }
		  return (true);
	}

