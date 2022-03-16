    /**
     * Removes characters unaccepted by OWM, such as spaces and carriage returns.
     *
     * @param query provided by user
     * @return query that can be submitted to OWM
     */
    private String preProcessQueryString(String query) {
        return query.replace(" ", "").replace("\n", "").replace("\r", "");
    }

