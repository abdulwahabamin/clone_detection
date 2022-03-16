    public static void appendLog(Context context, String tag, String text1, Intent value1, String text2, Class value2) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, (value1 != null)? value1.toString() : "null", text2, (value2 != null)? value2.toString() : "null");
    }

