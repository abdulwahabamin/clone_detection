    private static void initCrashReport(Context context) {
        Beta.autoInit = true;
        Beta.autoCheckUpgrade = true;
        Beta.initDelay = 3 * 1000;
        Beta.largeIconId = R.mipmap.core_icon;
        Beta.smallIconId = R.mipmap.core_icon;
        Beta.defaultBannerId = R.mipmap.core_icon;
        Beta.storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        Bugly.init(context, BUGLY_APPID, BuildConfig.DEBUG);
    }

