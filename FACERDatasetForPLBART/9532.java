    /**
     * Method that add a file to the category
     *
     * @param category The category
     */
    public void addFileToCategory(MimeTypeCategory category) {
        long count = this.mStatistics.get(category.ordinal()).longValue();
        count++;
        this.mStatistics.put(category.ordinal(), Long.valueOf(count));
    }

