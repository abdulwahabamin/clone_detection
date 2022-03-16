    public static boolean shouldRefresh(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        int refreshInterval = Integer.valueOf(sp.getString(Extras.KEY_REFRESH_INTERVAL, "1"));
        if (refreshInterval == 0) {
            return false;
        }
        long lastRefreshTime = sp.getLong(Extras.KEY_LAST_REFRESH_TIME, 0);
        long nowTime = System.currentTimeMillis();
        return nowTime - lastRefreshTime >= refreshInterval * DateUtils.HOUR_IN_MILLIS;
    }

