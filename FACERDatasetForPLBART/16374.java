    /**
     * 退出应用程�?
     */
    public void exitApplication() {
        try {
            finishAllActivity();
            ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            if (activityManager != null) {
                activityManager.killBackgroundProcesses(getPackageName());
            }
            System.exit(0);
        } catch (Exception e) {
            KLog.e("退出App异常:" + e.getMessage());
        }
    }

