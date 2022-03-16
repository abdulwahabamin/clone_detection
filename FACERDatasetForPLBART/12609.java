    /**
     * {@inheritDoc}
     */
    @Override
    protected Boolean doInBackground(String... params) {
        //Running
        this.mRunning = true;

        //Extract the directory from arguments
        String dir = params[0];

        //Extract filesystem mount point from directory
        if (isCancelled()) {
            return Boolean.TRUE;
        }
        final MountPoint mp = MountPointHelper.getMountPointFromDirectory(dir);
        if (mp == null) {
            //There is no information about
            if (isCancelled()) {
                return Boolean.TRUE;
            }
            ((Activity)mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Theme theme = ThemeManager.getCurrentTheme(FilesystemAsyncTask.this.mContext);
                    theme.setImageDrawable(
                            FilesystemAsyncTask.this.mContext,
                            FilesystemAsyncTask.this.mMountPointInfo,
                            FilesystemAsyncTask.this.mIsDialog ?
                                    "filesystem_dialog_warning_drawable" //$NON-NLS-1$
                                    : "filesystem_warning_drawable"); //$NON-NLS-1$
                    FilesystemAsyncTask.this.mMountPointInfo.setTag(null);
                }
            });
        } else {
            //Set image icon an save the mount point info
            if (isCancelled()) {
                return Boolean.TRUE;
            }
            ((Activity)mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                   String resource =
                            MountPointHelper.isReadOnly(mp)
                            ? FilesystemAsyncTask.this.mIsDialog ?
                                    "filesystem_dialog_locked_drawable" //$NON-NLS-1$
                                    : "filesystem_locked_drawable" //$NON-NLS-1$
                            : FilesystemAsyncTask.this.mIsDialog ?
                                    "filesystem_dialog_unlocked_drawable" //$NON-NLS-1$
                                    : "filesystem_unlocked_drawable"; //$NON-NLS-1$
                    Theme theme = ThemeManager.getCurrentTheme(FilesystemAsyncTask.this.mContext);
                    theme.setImageDrawable(
                            FilesystemAsyncTask.this.mContext,
                            FilesystemAsyncTask.this.mMountPointInfo,
                            resource);
                    FilesystemAsyncTask.this.mMountPointInfo.setTag(mp);
                }
            });

            //Load information about disk usage
            if (isCancelled()) {
                return Boolean.TRUE;
            }
            ((Activity)mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    DiskUsage du = null;
                    try {
                         du = MountPointHelper.getMountPointDiskUsage(mp);
                    } catch (Exception e) {
                        Log.e(TAG, "Failed to retrieve disk usage information", e); //$NON-NLS-1$
                        du = new DiskUsage(
                                mp.getMountPoint(), 0, 0, 0);
                    }
                    int usage = 0;
                    if (du != null && du.getTotal() != 0) {
                        usage = (int)(du.getUsed() * 100 / du.getTotal());
                        FilesystemAsyncTask.this.mDiskUsageInfo.setProgress(usage);
                        FilesystemAsyncTask.this.mDiskUsageInfo.setTag(du);
                    } else {
                        usage = du == null ? 0 : 100;
                        FilesystemAsyncTask.this.mDiskUsageInfo.setProgress(usage);
                        FilesystemAsyncTask.this.mDiskUsageInfo.setTag(null);
                    }

                    // Advise about diskusage (>=mFreeDiskSpaceWarningLevel) with other color
                    Theme theme = ThemeManager.getCurrentTheme(FilesystemAsyncTask.this.mContext);
                    int filter =
                            usage >= FilesystemAsyncTask.this.mFreeDiskSpaceWarningLevel ?
                               theme.getColor(
                                       FilesystemAsyncTask.this.mContext,
                                       "disk_usage_filter_warning_color") : //$NON-NLS-1$
                               theme.getColor(
                                       FilesystemAsyncTask.this.mContext,
                                       "disk_usage_filter_normal_color"); //$NON-NLS-1$
                    FilesystemAsyncTask.this.mDiskUsageInfo.
                                getProgressDrawable().setColorFilter(
                                        new PorterDuffColorFilter(filter, Mode.MULTIPLY));
                }
            });
        }
        return Boolean.TRUE;
    }

