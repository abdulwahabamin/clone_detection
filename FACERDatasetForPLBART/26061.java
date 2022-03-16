    public static String stackTraceOf(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            t.printStackTrace(pw);
        } catch (Throwable throwable) {
            error("stackTraceOf", "" + throwable);
        }
        return sw.toString();
    }

