    public static void appendLog(Context context, String tag, String text1, Sensor value1, String text2, float value2, String text3, int value3) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, String.valueOf(value1), text2, String.valueOf(value2), text3, String.valueOf(value3));
    }

