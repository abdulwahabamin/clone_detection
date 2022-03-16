    /**
     * Constructor of <code>FilesystemInfoDialog</code>.
     *
     * @param context The current context
     * @param mountPoint The mount point information
     * @param diskUsage The disk usage of the mount point
     */
    public FilesystemInfoDialog(Context context, MountPoint mountPoint, DiskUsage diskUsage) {
        super();

        //Save the context
        this.mContext = context;

        //Save data
        this.mMountPoint = mountPoint;
        mFetchStatsByTypeTask = new FetchStatsByTypeTask(this.mContext, this);
        fetchStats(mMountPoint.getMountPoint());
        this.mDiskUsage = diskUsage;
        this.mIsMountAllowed = false;
        this.mIsAdvancedMode =
                FileManagerApplication.getAccessMode().compareTo(AccessMode.SAFE) != 0;

        //Inflate the content
        LayoutInflater li =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mContentView = li.inflate(R.layout.filesystem_info_dialog, null);

        // Apply the current theme
        applyTheme();

        //Create the dialog
        this.mDialog = DialogHelper.createDialog(
                                        context,
                                        0,
                                        R.string.filesystem_info_dialog_title,
                                        this.mContentView);
        this.mDialog.setButton(
                DialogInterface.BUTTON_NEGATIVE,
                this.mContext.getString(android.R.string.ok),
                (DialogInterface.OnClickListener)null);

        //Fill the dialog
        fillData(this.mContentView);
    }

