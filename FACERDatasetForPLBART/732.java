    private static String generateTag(StackTraceElement caller) {
        String tag = "(%s:%d).%s"; // �?��?符
        String callerClazzName = caller.getFileName();
        tag = String.format(tag, callerClazzName, caller.getLineNumber(), caller.getMethodName()); // 替�?�
        tag = (TAG == null || "".equalsIgnoreCase(TAG)) ? tag : TAG + ":"
                + tag;
        return tag;
    }

