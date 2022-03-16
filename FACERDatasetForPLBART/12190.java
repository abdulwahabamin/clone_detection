    /**
     * Method that returns the virtual mount point for this console
     *
     * @return String The virtual mount point
     */
    public final File getVirtualMountPoint() {
        return new File(getVirtualStorageDir(), getMountPointName());
    }

