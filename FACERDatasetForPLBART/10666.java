    /**
     * Method that returns the name of file
     *
     * @param stat The terse stat data
     * @return String The name of file
     */
    private static String getTerseStatName(String[] stat) {
        int cc = stat.length;
        int to = cc - (TERSE_STAT_STRUCT_LENGTH - TERSE_STAT_STRUCT.SIZE.ordinal());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < to; i++) {
            sb.append(stat[i]);
            if (i < to-1) {
                sb.append(" "); //$NON-NLS-1$
            }
        }
        return sb.toString();
    }

