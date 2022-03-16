    /**
     * Method that returns the terms of the query in a single string separated by ", " string.
     *
     * @return String The terms of the query
     */
    public String getTerms() {
        String terms = TextUtils.join(", ", getQueries().toArray(new String[]{})); //$NON-NLS-1$;
        if (terms.endsWith(", ")) { //$NON-NLS-1$;
            terms = ""; //$NON-NLS-1$;
        }
        return terms;
    }

