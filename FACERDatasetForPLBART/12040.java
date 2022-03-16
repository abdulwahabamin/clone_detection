    /**
     * Constructor of <code>ReadOnlyFilesystemException</code>.
     *
     * @param mp The read-only mount point that causes the {@link ReadOnlyFilesystemException}
     */
    public ReadOnlyFilesystemException(MountPoint mp) {
        super(mp.getMountPoint());
        this.mMountPoint = mp;
    }

