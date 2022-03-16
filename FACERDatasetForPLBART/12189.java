    /**
     * Returns if the passed directory is the virtual mountpoint directory of the virtual console
     *
     * @param directory The directory to check
     * @return boolean If is the virtual mountpoint directory of the virtual console
     */
    public boolean isVirtualMountPointDir(String directory) {
        return getVirtualMountPoint().equals(new File(directory));
    }

