    public static void appendLog(Context context, String tag, String text1, Sensor value1, String text2, float value2) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, String.valueOf(value1), text2, String.valueOf(value2));
    }

