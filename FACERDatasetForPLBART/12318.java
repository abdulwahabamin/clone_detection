    /**
     * Method that returns the number of files for a {@link MimeTypeCategory}.
     *
     * @param category The category
     * @return long The number of files for the category
     */
    public long getStatisticsForCategory(MimeTypeCategory category) {
        return this.mStatistics.get(category.ordinal()).longValue();
    }

