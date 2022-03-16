    public static void e(String uTag, String content, boolean isSaveLog) {
        if (!allowE) {
            return;
        }
        TAG = uTag;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        loge(tag, content, null);
        if (isSaveLog && isAndroid) {
            point(PATH_LOG_INFO, tag, content);
        }
    }

