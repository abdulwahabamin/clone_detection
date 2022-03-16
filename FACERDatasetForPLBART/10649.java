    /**
     * Method that retrieve the mount point information for a directory.
     *
     * @param console The console in which realize the operation
     * @param dir The directory of which recovers his mount point information
     * @return MountPoint The mount point information
     */
    public static MountPoint getMountPointFromDirectory(Console console, String dir) {
        try {
            // For non-rooted devices, which console is java and runs under a chrooted
            // device, mount point info mustn't be a main objective. Caching the status
            // should be enough and operation runs smoothly.
            // Refresh mount points after some time (5 minutes should be enough)
            long now = System.currentTimeMillis();
            synchronized(sMountPoints) {
                if (sMountPoints == null || (now - sLastCachedTime) > MAX_CACHED_TIME || FileManagerApplication.hasShellCommands()) {
                    //Retrieve the mount points
                    refreshMountPoints(console);
                }
                if (sMountPoints == null) {
                    return null;
                }

                //Sort mount points in reverse order, needed for avoid
                //found an incorrect mount point that matches the name
                Collections.sort(sMountPoints, new Comparator<MountPoint>() {
                    @Override
                    public int compare(MountPoint lhs, MountPoint rhs) {
                        return lhs.compareTo(rhs) * -1;
                    }
                });

                //Search for the mount point information
                int cc = sMountPoints.size();
                for (int i = 0; i < cc; i++) {
                    MountPoint mp = sMountPoints.get(i);
                    if (dir.startsWith(mp.getMountPoint())) {
                        return mp;
                    }
                }
            }

        } catch (Exception e) {
            Log.e(TAG, "Failed to retrieve the mount point information", e); //$NON-NLS-1$
        }

        //No mount point found
        return null;
    }

