    private static String getCallerFilename(StackTraceElement element) {
        try {
            String fileName = element.getFileName();
            return fileName;
        } catch (Throwable throwable) {
            MLog.error("MLog", "getCallerFilename " + throwable);
        }
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        if (stack != null && stack.length > 0) {
            return stack[stack.length - 1].getFileName();
        }
        return "";
    }

