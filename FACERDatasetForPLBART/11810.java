    /**
     * Method that create the arguments of this command, using the directory and
     * arguments and creating the regular expressions of the search.
     *
     * @param directory The directory where to search
     * @param query The query make for user
     * @return String[] The arguments of the command
     */
    private static String[] createArgs(String directory, Query query) {
        String[] args = new String[query.getSlotsCount() + 1];
        args[0] = directory;
        int cc = query.getSlotsCount();
        for (int i = 0; i < cc; i++) {
            args[i + 1] = SearchHelper.toRegExp(query.getSlot(i), false);
        }
        return args;
    }

