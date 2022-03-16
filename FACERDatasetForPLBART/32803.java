    public static void appendLog(Context context, String tag, String text1, Location value1, String text2, boolean value2) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, (value1 != null)? value1.toString() : "null", text2, String.valueOf(value2));
    }

