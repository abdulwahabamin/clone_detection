    /**
     * èŽ·å?–versionName
     *
     * @param context ä¸Šä¸‹æ–‡
     * @return ç‰ˆæœ¬å?·
     */
    private static String getVersionName(Context context) {
        String versionName = "";
        try {
            versionName = context.getPackageManager().
                    getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "v" + versionName;
    }

