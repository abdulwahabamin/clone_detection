    public static void appendLogWithDate(Context context, String tag, String text1, long value1) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, text1, DATE_FORMATTER.format(new Date(value1)));
    }

