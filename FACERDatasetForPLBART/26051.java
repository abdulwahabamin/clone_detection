    private static String getCallerMethodName(StackTraceElement element) {
        try {
            return element.getMethodName();
        } catch (Throwable throwable) {
            MLog.error("MLog", "getCallerMethodName " + throwable);
        }
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        if (stack != null && stack.length > 0) {
            return stack[stack.length - 1].getMethodName();
        }
        return "";
    }

