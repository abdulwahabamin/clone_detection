    private static int getCallerLineNumber(StackTraceElement element) {
        try {
            int line = element.getLineNumber();
            return line;
        } catch (Throwable throwable) {
            MLog.error("MLog", "getCallerLineNumber " + throwable);
        }
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        if (stack != null && stack.length > 0) {
            return stack[stack.length - 1].getLineNumber();
        }
        return 0;
    }

