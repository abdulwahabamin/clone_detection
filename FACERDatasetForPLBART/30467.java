    /**
     * 获�?�versionName
     *
     * @param context 上下文
     * @return 版本�?�
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

