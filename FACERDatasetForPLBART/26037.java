    /**
     * Output an error log with contents of a Throwable.
     *
     * NOTE {@link #initialize(String)} or
     * {@link #initialize(String, LogOptions)} must be called before calling
     * this.
     *
     * @param t
     *            An Throwable instance.
     */
    public static void error(Object obj, Throwable t) {
        if (shouldWriteError()) {
//            StackTraceElement element = getStackTraceElements()[3];
//            int line = getCallerLineNumber(element);
//            String filename = getCallerFilename(element);
//            String methodname = getCallerMethodName(element);
            outputError(obj, t, -1, "", "");
        }
    }

