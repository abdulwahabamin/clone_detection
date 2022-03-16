    public static void appendLog(Context context, String tag, String text1, long value1, String text2, Class value2) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, String.valueOf(value1), text2, (value2 != null)? value2.toString() : "null");
    }

