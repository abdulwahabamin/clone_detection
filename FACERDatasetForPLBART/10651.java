    /**
     * Method that retrieve information about the disk usage of the mount point.
     *
     * @param console The console in which realize the operation
     * @param mp The mount point
     * @return DiskUsage The disk usage information
     */
    public static DiskUsage getMountPointDiskUsage(Console console, MountPoint mp) {
        try {
            //Retrieve the mount points
            return CommandHelper.getDiskUsage(null, mp.getMountPoint(), console);

        } catch (Exception e) {
            Log.e(TAG,
                    String.format("Fail to load disk usage of mount point: %s",  //$NON-NLS-1$
                            mp.getMountPoint()), e);
        }

        //No mount point found
        return null;
    }

