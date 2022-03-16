    public static void appendLog(Context context, String tag, String text1, int value1, int value2, int value3, int value4, int value5, int value6) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, String.format("%d|%s|%d|%d|%s|%d", value1, value2, value3, value4, value5, value6));
    }

