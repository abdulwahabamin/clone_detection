    /**
     * Method that returns the virtual console for the path or null if the path
     * is not a virtual filesystem
     *
     * @param path the path to check
     * @return VirtualMountPointConsole The found console
     */
    public static VirtualMountPointConsole getVirtualConsoleForPath(String path) {
        File file = new File(path);
        for (VirtualMountPointConsole console : sVirtualConsoles) {
            if (FileHelper.belongsToDirectory(file, console.getVirtualMountPoint())) {
                return console;
            }
        }
        return null;
    }

