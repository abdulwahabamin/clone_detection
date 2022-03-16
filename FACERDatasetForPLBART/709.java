    public static void i(String uTag, String content, boolean isSaveLog) {
        if (!allowI) {
            return;
        }
        TAG = uTag;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        logi(tag, content);
        if (isSaveLog && isAndroid) {
            point(PATH_LOG_INFO, tag, content);
        }
    }

