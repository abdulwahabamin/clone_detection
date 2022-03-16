    /**
     * Constructor of <code>DiskUsageCommand</code>.
     *
     * @param mountsFile The system mounts file
     * @param dir The directory of which obtain its disk usage
     */
    public DiskUsageCommand(String mountsFile, String dir) {
        super();
        this.mMountsFile = mountsFile;
        this.mSrc = null;
        this.mDisksUsage = new ArrayList<DiskUsage>();
    }

