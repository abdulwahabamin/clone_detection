    @Override
    public synchronized void updateMountPointInfo() {
        //Cancel the current execution (if any) and launch again
        if (this.mFilesystemAsyncTask != null && this.mFilesystemAsyncTask.isRunning()) {
            this.mFilesystemAsyncTask.cancel(true);
        }
        final ImageView filesystemInfo = (ImageView)findViewById(R.id.ab_filesystem_info);
        final ProgressBar diskUsageInfo = (ProgressBar)findViewById(R.id.breadcrumb_diskusage);
        this.mFilesystemAsyncTask =
                new FilesystemAsyncTask(
                        getContext(), filesystemInfo,
                        diskUsageInfo, this.mFreeDiskSpaceWarningLevel, true);
        this.mFilesystemAsyncTask.execute(this.mCurrentPath);
    }

