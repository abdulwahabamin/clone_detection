    /**
     * Method that returns the last match position of a regexp,
     *
     * @param pattern The patter
     * @param input The input
     * @param withPattern Whether the return position should contains the pattern or not.
     * @return int The matched position or -1
     */
    public static int getLastMatch(Pattern pattern, CharSequence input, boolean withPattern) {
        Matcher m = pattern.matcher(input);
        int p = NO_MATCH;
        while (m.find()) {
            p = withPattern ? m.start() : m.end();
        }
        return p;
    }

