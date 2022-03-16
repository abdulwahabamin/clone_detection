    /**
     * Method that extract a long value from a terse stat ouput.
     *
     * @param stat The terse stat data
     * @param e The position of the date
     * @return long The long value
     */
    private static long getTerseStatLong(String[] stat, TERSE_STAT_STRUCT e) {
        int cc = stat.length;
        return Long.parseLong(stat[cc - (TERSE_STAT_STRUCT_LENGTH - e.ordinal())]);
    }

