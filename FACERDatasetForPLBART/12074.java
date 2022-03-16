    /**
     * Method that returns if the path belongs to the secure storage
     *
     * @param path The path to check
     * @return
     */
    public boolean isSecureStorageResource(String path) {
        return FileHelper.belongsToDirectory(new File(path), getVirtualMountPoint());
    }

