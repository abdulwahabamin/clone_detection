    /**
     * {@inheritDoc}
     */
    @Override
    public DiskUsage getDiskUsageInfo() {
        if (this.mDiskUsageInfo != null) {
            return (DiskUsage)this.mDiskUsageInfo.getTag();
        }
        return null;
    }

