    public static void e(Throwable tr) {
        if (!allowE)
            return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        String content = getThrowable(tr, null);
        loge(tag, content, null);
    }

