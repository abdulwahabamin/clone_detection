    /**
     * Method that retrieve information about the disk usage of the mount point.
     *
     * @param mp The mount point
     * @return DiskUsage The disk usage information
     */
    public static DiskUsage getMountPointDiskUsage(MountPoint mp) {
        return getMountPointDiskUsage(FileManagerApplication.getBackgroundConsole(), mp);
    }

