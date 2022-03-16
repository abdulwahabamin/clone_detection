    public static void e(String uTag, String content, Throwable tr, boolean isSaveLog) {
        if (!allowE)
            return;
        TAG = uTag;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        loge(tag, content, tr);

        String msg = getThrowable(tr, content);
        if (isSaveLog && isAndroid) {
            point(PATH_LOG_INFO, tag, msg);
        }
    }

