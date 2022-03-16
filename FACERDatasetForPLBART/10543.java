    /**
     * Method that prints the exception to an string
     *
     * @param cause The exception
     * @return String The stack trace in an string
     */
    public static String toStackTrace(Exception cause) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            cause.printStackTrace(pw);
            return sw.toString();
        } finally {
            try {
                pw.close();
            } catch (Exception e) {/**NON BLOCK**/}
        }
    }

