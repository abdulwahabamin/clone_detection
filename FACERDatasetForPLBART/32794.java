    public static void appendLog(Context context, String tag, String text1, android.location.Location value1, String text2, double value2, String text3, double value3, String text4, String text5) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, (value1 != null)? value1.toString() : "null", text2, String.valueOf(value2), text3, String.valueOf(value3), text4, text5);
    }

