    /**
     * Method that parse the result of a shell program invocation.
     *
     * @param in The standard input buffer
     * @param err The standard error buffer
     * @throws ParseException If the output is not well-formed
     */
    void parse(String in, String err) throws ParseException;

