    public static void appendLog(Context context, String tag, String text1, PowerManager value1) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, (value1 != null)? value1.toString() : "null");
    }

