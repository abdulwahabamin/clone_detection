    /**
     * Constructor
     *
     * @param category  {@link com.cyanogenmod.filemanager.util.MimeTypeHelper.MimeTypeCategory}
     * @param sizeBytes {@link java.lang.Long}
     *
     * @throws IllegalArgumentException {@link java.lang.IllegalArgumentException}
     */
    public DiskUsageCategory(MimeTypeCategory category, long sizeBytes)
            throws IllegalArgumentException {
        if (category == null) {
            throw new IllegalArgumentException("'category' may not be null!");
        }
        mCategory = category;
        mSizeBytes = sizeBytes;
    }

