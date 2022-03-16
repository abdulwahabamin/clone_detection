    public static void e(String content, Throwable tr, boolean isSaveLog) {
        if (!allowE)
            return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        Log.e(tag, content, tr);
        if (isSaveLog && isAndroid) {
            point(PATH_LOG_INFO, tag, getThrowable(tr, content));
        }
    }

