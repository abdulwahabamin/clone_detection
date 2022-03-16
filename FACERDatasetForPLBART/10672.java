    /**
     * Method that cleans and prepares the query of the user to conform with a valid regexp.
     *
     * @param query The query requested by the user
     * @return String The prepared the query
     */
    private static String prepareQuery(String query) {
        StringBuilder sb = new StringBuilder(query.length());
        for (int i = 0; i < query.length(); ++i) {
            char ch = query.charAt(i);
            if (Character.isLetterOrDigit(ch) ||
                    ch == ' ' ||
                    ch == '\'') {
                sb.append(ch);
            } else if (ch == '*') {
                sb.append(".*"); //$NON-NLS-1$
            }
        }
        return sb.toString();
    }

