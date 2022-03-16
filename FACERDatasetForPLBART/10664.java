    /**
     * Method that extract a integer value from a terse stat ouput.
     *
     * @param stat The terse stat data
     * @param e The position of the date
     * @return int The integer value
     */
    private static int getTerseStatInt(String[] stat, TERSE_STAT_STRUCT e) {
        int cc = stat.length;
        return Integer.parseInt(stat[cc - (TERSE_STAT_STRUCT_LENGTH - e.ordinal())]);
    }

