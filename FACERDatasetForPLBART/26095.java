    /**
     * æ£€æµ‹ç½‘ç»œæ˜¯å?¦ä¸ºå?¯ç”¨çŠ¶æ€?
     */
    public static boolean isAvailable(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

