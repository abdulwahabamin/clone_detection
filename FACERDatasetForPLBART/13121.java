    /**
     * Method that ensures that the user don't go outside the ChRooted environment
     *
     * @param newDir The new directory to navigate to
     * @return String
     */
    private String checkChRootedNavigation(String newDir) {
        // If we aren't in ChRooted environment, then there is nothing to check
        if (!this.mChRooted) return newDir;

        // Check if the path is owned by one of the storage volumes
        if (!StorageHelper.isPathInStorageVolume(newDir)) {
            StorageVolume[] volumes = StorageHelper.getStorageVolumes(getContext(), false);
            if (volumes != null && volumes.length > 0) {
                return volumes[0].getPath();
            }
        }
        return newDir;
    }

