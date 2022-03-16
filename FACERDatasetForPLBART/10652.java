    /**
     * Method that returns if the filesystem is mounted as readonly.
     *
     * @param mp The mount point to check
     * @return boolean If the mount point is mounted as readonly
     */
    public static boolean isReadOnly(MountPoint mp) {
        try {
            return mp.getOptions().startsWith(MountExecutable.READONLY);
        } catch (Exception e) {
            Log.e(TAG, "Method \"isReadOnly\" failed.", e); //$NON-NLS-1$
        }

        //On fail is more secure consider it as read-only
        return true;
    }

