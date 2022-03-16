    /**
     * Method that refresh the mount point information.
     *
     * @return boolean refresh success or not.
     */
    public static boolean refreshMountPoints(Console console) {
        synchronized(sMountPoints) {
            try {
                sMountPoints.clear();
                sMountPoints.addAll(CommandHelper.getMountPoints(null, null));
                sLastCachedTime = System.currentTimeMillis();
                return true;
            } catch (Exception e) {
                Log.e(TAG, "Failed to update the mount point information", e); //$NON-NLS-1$
            }
        }
        return false;
    }

