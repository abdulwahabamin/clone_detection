    public static void appendLog(Context context, String tag, String text1, boolean value1, String text2, boolean value2) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, String.valueOf(value1), text2, String.valueOf(value2));
    }

