    /**
     * Method that create the regexp of this command, using the directory and
     * arguments and creating the regular expressions of the search.
     *
     * @param directory The directory where to search
     * @param query The query make for user
     * @return String[] The regexp for filtering files
     */
    private static String[] createRegexp(String directory, Query query) {
        String[] args = new String[query.getSlotsCount()];
        int cc = query.getSlotsCount();
        for (int i = 0; i < cc; i++) {
            args[i] = SearchHelper.toRegExp(query.getSlot(i), true);
        }
        return args;
    }

