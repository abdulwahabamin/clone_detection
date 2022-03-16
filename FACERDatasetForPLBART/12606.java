    /**
     * Constructor of <code>FilesystemAsyncTask</code>.
     *
     * @param context The current context
     * @param mountPointInfo The mount point info view
     * @param diskUsageInfo The mount point info view
     * @param freeDiskSpaceWarningLevel The free disk space warning level
     */
    public FilesystemAsyncTask(
            Context context, ImageView mountPointInfo,
            ProgressBar diskUsageInfo, int freeDiskSpaceWarningLevel) {
        this(context, mountPointInfo, diskUsageInfo, freeDiskSpaceWarningLevel,
                false);
    }

