    public static void d(String content, boolean isSaveLog) {
        if (!allowD)
            return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        logd(tag, content);
        if (isSaveLog && isAndroid) {
            point(PATH_LOG_INFO, tag, content);
        }
    }

