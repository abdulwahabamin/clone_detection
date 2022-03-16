    /**
     * Gets the column name for each week #
     *
     * @param week number
     * @return the column name
     */
    private static String getColumnNameForWeek(final int week) {
        return SongPlayCountColumns.WEEK_PLAY_COUNT + String.valueOf(week);
    }

