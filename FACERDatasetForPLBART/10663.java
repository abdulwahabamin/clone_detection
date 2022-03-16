    /**
     * Method that extract a date from a terse stat ouput.
     *
     * @param stat The terse stat data
     * @param e The position of the date
     * @return Date The date
     */
    private static Date getTerseStatDate(String[] stat, TERSE_STAT_STRUCT e) {
        int cc = stat.length;
        return new Date(
                Long.parseLong(stat[cc - (TERSE_STAT_STRUCT_LENGTH - e.ordinal())]) * 1000L);
    }

