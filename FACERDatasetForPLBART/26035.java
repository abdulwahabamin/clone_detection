    /**
     * Output an error log with contents of a Throwable.
     * Exception will be caught if input arguments have format error.
     *
     * NOTE {@link #initialize(String)} or
     * {@link #initialize(String, LogOptions)} must be called before calling
     * this.
     *
     * @param obj
     * @param format
     *            The format string such as "This is the %d sample : %s".
     * @param t
     *            An Throwable instance.
     * @param args
     *            The args for format.
     *
     *            Reference : boolean : %b. byte, short, int, long, Integer, Long
     *            : %d. NOTE %x for hex. String : %s. Object : %s, for this
     *            occasion, toString of the object will be called, and the
     *            object can be null - no exception for this occasion.
     *
     */
    public static void error(Object obj, String format, Throwable t, Object... args) {
        error(obj, format + '\n' + stackTraceOf(t), args);
    }

