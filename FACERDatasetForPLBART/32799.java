    public static void appendLogLastUpdateTime(Context context, String tag, String text1, WeatherForecastDbHelper.WeatherForecastRecord value1, String text2, long value2) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, (value1 != null)? String.valueOf(value1.getLastUpdatedTime()) : "null", text2, String.valueOf(value2));
    }

