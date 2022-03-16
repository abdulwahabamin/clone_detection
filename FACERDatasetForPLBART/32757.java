    public static void appendLogWithParams(Context context, String tag, String text, List<String> params) {
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        StringBuilder paramDescription = new StringBuilder();
        for (String param: params) {
            paramDescription.append(param);
            paramDescription.append(":");
        }
        appendLog(context, tag, text, paramDescription.toString());
    }

