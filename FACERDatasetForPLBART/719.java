    public static void e(String uTag, String content, Throwable tr) {
        if (!allowE)
            return;
        TAG = uTag;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        Log.e(tag, content, tr);
    }

