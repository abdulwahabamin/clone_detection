    /**
     * Constructor of <code>FilesystemAsyncTask</code>.
     *
     * @param context The current context
     * @param mountPointInfo The mount point info view
     * @param diskUsageInfo The mount point info view
     * @param freeDiskSpaceWarningLevel The free disk space warning level
     * @param isDialog Whether or not to use dialog theme resources
     */
    public FilesystemAsyncTask(
            Context context, ImageView mountPointInfo,
            ProgressBar diskUsageInfo, int freeDiskSpaceWarningLevel, boolean isDialog) {
        super();
        this.mContext = context;
        this.mMountPointInfo = mountPointInfo;
        this.mDiskUsageInfo = diskUsageInfo;
        this.mFreeDiskSpaceWarningLevel = freeDiskSpaceWarningLevel;
        this.mRunning = false;
        this.mIsDialog = isDialog;
    }

