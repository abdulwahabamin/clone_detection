    /**
     * Method that returns the next match position of a regexp,
     *
     * @param pattern The patter
     * @param input The input
     * @param withPattern Whether the return position should contains the pattern or not.
     * @return int The matched position or -1
     */
    public static int getNextMatch(Pattern pattern, CharSequence input, boolean withPattern) {
        Matcher m = pattern.matcher(input);
        int p = NO_MATCH;
        if (m.find()) {
            return withPattern ? m.end() : m.start();
        }
        return p;
    }

