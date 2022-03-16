    /**
     * Method that returns the virtual disk usage of the mountpoints of every register console
     * @return
     */
    public static List<DiskUsage> getVirtualDiskUsage() {
        List<DiskUsage> diskUsage = new ArrayList<DiskUsage>();
        for (VirtualMountPointConsole console : sVirtualConsoles) {
            diskUsage.addAll(console.getDiskUsage());
        }
        return diskUsage;
    }

