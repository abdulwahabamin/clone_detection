    /**
     * {@inheritDoc}
     */
    @Override
    public List<MountPoint> getMountPoints() {
        // This console only has one mountpoint
        List<MountPoint> mountPoints = new ArrayList<MountPoint>();
        String status = mIsMounted ? MountExecutable.READWRITE : MountExecutable.READONLY;
        mountPoints.add(new MountPoint(getVirtualMountPoint().getAbsolutePath(),
                "securestorage", "securestoragefs", status, 0, 0, true, false));
        return mountPoints;
    }

