    /**
     * Constructor of <code>MountPointInfoCommand</code>.
     *
     * @param mountsFile The system mounts file
     */
    public MountPointInfoCommand(String mountsFile) {
        super();
        this.mMountPoints = new ArrayList<MountPoint>();
        this.mMountsFile = mountsFile;
    }

