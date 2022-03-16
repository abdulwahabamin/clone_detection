    /**
     * èŽ·å?–Android_ID
     */
    public static String getAndroid_Id(Context context) {
        try {
            String androidId = Settings.System.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            return object2String(androidId, Build.UNKNOWN);
        } catch (Exception e) {
            return Build.UNKNOWN;
        }
    }

