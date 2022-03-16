    public static boolean isBrowseServiceRunning(Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            //Log.e("SERV",service.service.getClassName());
            if (BrowseService.class.getName().equals(service.service.getClassName())) {
            	//BLog.e("TESTSERVICE","BRIEF SERVICE TEST = IS NOT RUNNING");
                return true;
            }
        }
        return false;
    }

