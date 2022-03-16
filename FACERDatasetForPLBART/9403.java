    /**
     * Method that returns the virtual mountpoints of every register console
     * @return
     */
    public static List<MountPoint> getVirtualMountPoints() {
        List<MountPoint> mountPoints = new ArrayList<MountPoint>();
        for (VirtualMountPointConsole console : sVirtualConsoles) {
            mountPoints.addAll(console.getMountPoints());
        }
        return mountPoints;
    }

