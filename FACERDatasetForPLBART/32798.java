    public static void appendLogLocale(Context context, String tag, String text1, String[] localeParts, String text2, String value2) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        StringBuilder s = new StringBuilder();
        for (String pa: localeParts) {
            s.append(pa);
            s.append(":");
        }
        appendLog(context, tag, text1, s.toString(), text2, value2);
    }

