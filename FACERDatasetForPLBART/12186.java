    /**
     * Returns if the passed resource belongs to a virtual filesystem
     *
     * @param path The path to check
     * @return boolean If is the resource belongs to a virtual filesystem
     */
    public static boolean isVirtualStorageResource(String path) {
        for (VirtualMountPointConsole console : sVirtualConsoles) {
            if (FileHelper.belongsToDirectory(new File(path), console.getVirtualMountPoint())) {
                return true;
            }
        }
        return false;
    }

