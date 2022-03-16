    public static void appendLog(Context context, String tag, String text1, double value1, String text2, double value2, String text3, long value3, String text4, Address value4) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, String.valueOf(value1), text2, String.valueOf(value2), text3, String.valueOf(value3), text4, (value4 != null)? value4.toString() : "null");
    }

