    public static void e(Throwable tr, boolean isSaveLog) {
        if (!allowE)
            return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        String content = getThrowable(tr, null);
        loge(tag, content, null);
        if (isSaveLog && isAndroid) {
            point(PATH_LOG_INFO, tag, content);
        }
    }

