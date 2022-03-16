    /**
     * Add a usage category
     *
     * @param category {@link com.cyanogenmod.filemanager.model.DiskUsageCategory} not null
     *
     * @throws IllegalArgumentException {@link java.lang.IllegalArgumentException}
     */
    public void addUsageCategory(DiskUsageCategory category) throws IllegalArgumentException {
        if (category == null) {
            throw new IllegalArgumentException("'category' cannot be null!");
        }
        mDiskUsageCategoryList.add(category);
    }

