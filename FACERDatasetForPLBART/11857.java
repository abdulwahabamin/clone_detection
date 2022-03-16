    /**
     * {@inheritDoc}
     */
    @Override
    public MountPoint getSrcWritableMountPoint() {
        return MountPointHelper.getMountPointFromDirectory(this.mSrc);
    }

