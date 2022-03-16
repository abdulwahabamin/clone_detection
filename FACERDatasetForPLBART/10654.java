    /**
     * Method that returns if a filesystem is allowed to be mounted/unmounted (rw/ro).
     *
     * @param mp The mount point to check
     * @return boolean If the mount point can be mounted/unmount (rw/ro)
     */
    public static boolean isMountAllowed(MountPoint mp) {
        return !RESTRICTED_FS_TYPE.contains(mp.getType());
    }

