    public static void e(String uTag, String content) {
        if (!allowE) {
            return;
        }
        TAG = uTag;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        loge(tag, content, null);
    }

