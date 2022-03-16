    public static void appendLog(Context context, String tag, String text1, List value1, String text2, List value2) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, (value1 != null)? (value1 + ":" + String.valueOf(value1.size())) : "null", text2, (value2 != null)? (value2 + ":" + String.valueOf(value2.size())) : "null");
    }

