    /**
     * Method that create a regular expression from a user query.
     *
     * @param query The query requested by the user
     * @param javaRegExp If returns a java regexp
     * @return String The regular expressions of the query to match an ignore case search
     */
    @SuppressWarnings("boxing")
    public static String toRegExp(final String query, boolean javaRegExp) {
        //Check that all is correct
        if (query == null || query.trim().length() == 0) {
            return "";  //$NON-NLS-1$
        }

        // If the regexp for java, then prepare the query
        String q = query;
        if (javaRegExp) {
            q = prepareQuery(q);
        }

        return String.format(
                    "%s%s%s",  //$NON-NLS-1$;
                    javaRegExp ? REGEXP_WILCARD_JAVA : REGEXP_WILCARD,
                    q, javaRegExp ? REGEXP_WILCARD_JAVA : REGEXP_WILCARD);
    }

