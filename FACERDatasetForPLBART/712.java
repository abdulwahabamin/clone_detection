    public static void w(String uTag, String content) {
        if (!allowW) {
            return;
        }
        TAG = uTag;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        logw(tag, content);
    }

