    public static void appendLog(Context context, String tag, String text1, long value1, String text2, String text3) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, String.valueOf(value1), text2, text3);
    }

