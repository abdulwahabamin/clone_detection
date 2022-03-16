    /**
     * Method that retrieve the mount point information for a directory.
     *
     * @param dir The directory of which recovers his mount point information
     * @return MountPoint The mount point information
     */
    public static MountPoint getMountPointFromDirectory(FileSystemObject dir) {
        return getMountPointFromDirectory(dir.getFullPath());
    }

