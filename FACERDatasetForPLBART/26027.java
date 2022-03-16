    /**
     * Output debug log. This version aims to improve performance by removing
     * the string concatenated costs on release version. Exception will be
     * caught if input arguments have format error.
     *
     * NOTE {@link #initialize(String)} or
     * {@link #initialize(String, LogOptions)} must be called before calling
     * this.
     *
     * @param obj
     * @param format
     *            The format string such as "This is the %d sample : %s".
     * @param args
     *            The args for format.
     *
     *            Reference : boolean : %b. byte, short, int, long, Integer, Long
     *            : %d. NOTE %x for hex. String : %s. Object : %s, for this
     *            occasion, toString of the object will be called, and the
     *            object can be null - no exception for this occasion.
     *
     */
    public static void debug(Object obj, String format, Object... args) {
        if (shouldWriteDebug()) {
//            StackTraceElement element = getStackTraceElements()[4];
//            int line = getCallerLineNumber(element);
//            String filename = getCallerFilename(element);
            outputDebug(obj, format, getThreadName(), -1, "", args);
        }
    }

