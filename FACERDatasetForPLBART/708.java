    public static void i(String uTag, String content) {
        if (!allowI) {
            return;
        }
        TAG = uTag;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);

        logi(tag, content);
    }

