    /**
     * èŽ·å?–IMEI
     */
    @SuppressLint("HardwareIds")
    private static String getDeviceId(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                return Build.UNKNOWN;
            } else if (telephonyManager != null) {
                String imei = telephonyManager.getDeviceId();
                if (TextUtils.isEmpty(imei)) {
                    return Build.UNKNOWN;
                }
                return "B" + imei;
            } else {
                return Build.UNKNOWN;
            }
        } catch (Exception e) {
            return Build.UNKNOWN;
        }
    }

