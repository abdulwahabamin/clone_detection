    /**
     * {@inheritDoc}
     */
    @Override
    public DiskUsage getDiskUsage(String path) {
        if (isSecureStorageResource(path)) {
            return getDiskUsage().get(0);
        }
        return null;
    }

