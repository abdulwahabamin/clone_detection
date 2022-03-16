    private static String generateTag(StackTraceElement caller) {
        String tag = "(%s:%d).%s"; // å? ä½?ç¬¦
        String callerClazzName = caller.getFileName();
        tag = String.format(tag, callerClazzName, caller.getLineNumber(), caller.getMethodName()); // æ›¿æ?¢
        tag = (TAG == null || "".equalsIgnoreCase(TAG)) ? tag : TAG + ":"
                + tag;
        return tag;
    }

