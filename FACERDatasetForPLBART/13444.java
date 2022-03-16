    /**
     * Method that returns if the filesystem is mounted as read-write.
     *
     * @param mp The mount point to check
     * @return boolean If the mount point is mounted as read-write
     */
    public static boolean isReadWrite(MountPoint mp) {
        try {
            return mp.getOptions().startsWith(MountExecutable.READWRITE);
        } catch (Exception e) {
            Log.e(TAG, "Method \"isReadWrite\" failed.", e); //$NON-NLS-1$
        }

        //On fail is more secure consider it as read-only
        return false;
    }

