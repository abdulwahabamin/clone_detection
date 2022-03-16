    public static void setAppHomePath(Context context) {
        if(HOME_PATH_APP==null && context.getApplicationInfo()!=null) {
            HOME_PATH_APP = context.getApplicationInfo().dataDir + "/briefdata";
        }
		//Log.e("PATH",HOME_PATH_APP);
    }

