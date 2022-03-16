	public static int getAndroidSDKLevel() {
      int sdkInt;
	  try {
		  
		  // this is the non-deprecated way to get the version: 
		  //
		  // sdkInt = Build.VERSION.SDK_INT;
		  //
		  // ... but on Cupcake it will cause a VerifyError exception 
		  // the first time any class references anything in VersionUtils. 
		  //
	      // So for now we use the deprecated string version. However we should switch to
		  // just referencing Build.VERSION.SDK if we ever have other reasons to 
	      // stop supporting Android 1.5.
		  //
	      sdkInt = Integer.parseInt(Build.VERSION.SDK);
	    } catch (NumberFormatException nfe) {
	      // Just to be safe
	      sdkInt = 10000;
	    }
	    return sdkInt;
	}

