    /**
     * Method that returns the total sum of all categories
     *
     * @return {@link java.lang.Long}
     */
    public long getCategorySum() {
        long bytes = 0;
        for (DiskUsageCategory category : getUsageCategoryList()) {
            bytes += category.getSizeBytes();
        }
        return bytes;
    }

