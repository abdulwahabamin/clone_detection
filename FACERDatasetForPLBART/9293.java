    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("deprecation")
    public List<DiskUsage> getDiskUsage() {
        // This console only has one mountpoint, and is fully usage
        List<DiskUsage> diskUsage = new ArrayList<DiskUsage>();
        File mp = mStorageRoot.getFile();
        diskUsage.add(new DiskUsage(mp.getAbsolutePath(),
                mp.getTotalSpace(),
                mp.length(),
                mp.getTotalSpace() - mp.length()));
        return diskUsage;
    }

