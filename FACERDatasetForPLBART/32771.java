    public static void appendLog(Context context, String tag, String text1, Long value1, Long value2, double value3, double value4) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1 + ":" + value1 + ":" + value2 + ":" + value3 + ":" + value4);
    }

