    /**
     * {@inheritDoc}
     */
    @Override
    public MountPoint getMountPointInfo() {
        if (this.mFilesystemInfo != null) {
            return (MountPoint)this.mFilesystemInfo.getTag();
        }
        return null;
    }

