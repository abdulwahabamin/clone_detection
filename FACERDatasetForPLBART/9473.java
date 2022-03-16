    /**
     * Constructor of <code>DiskUsage</code>.
     *
     * @param mountPoint The mount point
     * @param total The total amount of space
     * @param used The used amount of space
     * @param free The free amount of space
     */
    public DiskUsage(String mountPoint, long total, long used, long free) {
        super();
        this.mMountPoint = mountPoint;
        this.mTotal = total;
        this.mUsed = used;
        this.mFree = free;
    }

