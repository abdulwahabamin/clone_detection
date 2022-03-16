    /**
     * Method that retrieve the mount point information for a directory.
     *
     * @param dir The directory of which recovers his mount point information
     * @return MountPoint The mount point information
     */
    public static MountPoint getMountPointFromDirectory(String dir) {
        try {
            return getMountPointFromDirectory(FileManagerApplication.getBackgroundConsole(), dir);
        } catch (Exception e) {
            Log.e(TAG, "Failed to retrieve mount point information.", e); //$NON-NLS-1$
        }
        return null;
    }

