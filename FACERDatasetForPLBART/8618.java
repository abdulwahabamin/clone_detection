    /**
     * Method that create a reference of the disk usage from the root file
     *
     * @param root The root file
     * @return DiskUsage The disk usage
     */
    private DiskUsage createDiskUsuage(File file) {
        DiskUsage du = new DiskUsage(
                                file.getAbsolutePath(),
                                file.getTotalSpace(),
                                file.getTotalSpace() - file.getFreeSpace(),
                                file.getFreeSpace());
        if (isTrace()) {
            Log.v(TAG, du.toString());
        }
        return du;
    }

