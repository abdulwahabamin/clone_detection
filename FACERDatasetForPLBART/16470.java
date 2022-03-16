    /**
     * èŽ·å?–androidId
     *
     * @return
     */
    public static String getAndroidId() {
        String androidId = Settings.System.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        if (androidId == null || TextUtils.isEmpty(androidId)) {
            androidId = randomStr(16);
        }
        return androidId;
    }

