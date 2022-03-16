    /**
     * Method that creates a ChRooted environment, protecting the user to break anything
     * in the device
     * @hide
     */
    public void createChRooted() {
        // If we are in a ChRooted environment, then do nothing
        if (this.mChRooted) return;
        this.mChRooted = true;

        //Change to first storage volume
        StorageVolume[] volumes =
                StorageHelper.getStorageVolumes(getContext(), false);
        if (volumes != null && volumes.length > 0) {
            changeCurrentDir(volumes[0].getPath(), false, true, false, null, null);
        }
    }

