    /**
     * Method that fill the dialog with the data of the mount point.
     *
     * @param contentView The content view
     */
    @SuppressWarnings({ "boxing" })
    private void fillData(View contentView) {
        //Get the tab views
        this.mInfoViewTab = contentView.findViewById(R.id.filesystem_info_dialog_tab_info);
        this.mDiskUsageViewTab =
                contentView.findViewById(R.id.filesystem_info_dialog_tab_disk_usage);
        this.mInfoView = contentView.findViewById(R.id.filesystem_tab_info);
        this.mDiskUsageView = contentView.findViewById(R.id.filesystem_tab_diskusage);
        this.mDiskUsageGraph =
                (DiskUsageGraph)contentView.findViewById(R.id.filesystem_disk_usage_graph);

        this.mLegendLayout = (GridLayout) contentView.findViewById(R.id.ll_legend);

        // Set the user preference about free disk space warning level
        String fds = Preferences.getSharedPreferences().getString(
                FileManagerSettings.SETTINGS_DISK_USAGE_WARNING_LEVEL.getId(),
                (String)FileManagerSettings.
                    SETTINGS_DISK_USAGE_WARNING_LEVEL.getDefaultValue());
        this.mDiskUsageGraph.setFreeDiskSpaceWarningLevel(Integer.parseInt(fds));

        //Register the listeners
        this.mInfoViewTab.setOnClickListener(this);
        this.mDiskUsageViewTab.setOnClickListener(this);

        //Gets text views
        this.mSwStatus = (Switch)contentView.findViewById(R.id.filesystem_info_status);
        TextView tvMountPoint =
                (TextView)contentView.findViewById(R.id.filesystem_info_mount_point);
        TextView tvDevice = (TextView)contentView.findViewById(R.id.filesystem_info_device);
        TextView tvType = (TextView)contentView.findViewById(R.id.filesystem_info_type);
        TextView tvOptions = (TextView)contentView.findViewById(R.id.filesystem_info_options);
        TextView tvDumpPass = (TextView)contentView.findViewById(R.id.filesystem_info_dump_pass);
        TextView tvTotal =
                (TextView)contentView.findViewById(R.id.filesystem_info_total_disk_usage);
        TextView tvUsed = (TextView)contentView.findViewById(R.id.filesystem_info_used_disk_usage);
        TextView tvFree = (TextView)contentView.findViewById(R.id.filesystem_info_free_disk_usage);
        this.mInfoMsgView = (TextView)contentView.findViewById(R.id.filesystem_info_msg);

        //Fill the text views
        tvMountPoint.setText(this.mMountPoint.getMountPoint());
        tvDevice.setText(this.mMountPoint.getDevice());
        tvType.setText(this.mMountPoint.getType());
        tvOptions.setText(this.mMountPoint.getOptions());
        tvDumpPass.setText(
                String.format("%d / %d",  //$NON-NLS-1$
                        this.mMountPoint.getDump(),
                        this.mMountPoint.getPass()));
        if (this.mDiskUsage != null) {
            tvTotal.setText(FileHelper.getHumanReadableSize(this.mDiskUsage.getTotal()));
            tvUsed.setText(FileHelper.getHumanReadableSize(this.mDiskUsage.getUsed()));
            tvFree.setText(FileHelper.getHumanReadableSize(this.mDiskUsage.getFree()));
        } else {
            tvTotal.setText("-"); //$NON-NLS-1$
            tvUsed.setText("-"); //$NON-NLS-1$
            tvFree.setText("-"); //$NON-NLS-1$
        }

        //Configure status switch
        boolean isVirtual = this.mMountPoint.isVirtual();
        boolean hasPrivileged = false;
        try {
            hasPrivileged = ConsoleBuilder.isPrivileged();
        } catch (Throwable ex) {/**NON BLOCK**/}
        boolean mountAllowed =
                MountPointHelper.isMountAllowed(this.mMountPoint);
        if (!isVirtual || this.mIsAdvancedMode) {
            if (hasPrivileged) {
                if (!mountAllowed) {
                    this.mInfoMsgView.setText(
                            this.mContext.getString(
                                    R.string.filesystem_info_cant_be_mounted_msg));
                    this.mInfoMsgView.setVisibility(View.VISIBLE);
                }
            } else {
                this.mInfoMsgView.setVisibility(View.VISIBLE);
                this.mInfoMsgView.setOnClickListener(this);
            }
        } else {
            mountAllowed = false;
            this.mInfoMsgView.setVisibility(View.GONE);
            this.mInfoMsgView.setOnClickListener(null);
        }
        this.mIsMountAllowed = isVirtual || (hasPrivileged && mountAllowed && this.mIsAdvancedMode);
        this.mSwStatus.setEnabled(this.mIsMountAllowed);
        this.mSwStatus.setChecked(MountPointHelper.isReadWrite(this.mMountPoint));

        // Add the listener after set the value to avoid raising triggers
        this.mSwStatus.setOnCheckedChangeListener(this);

        //Change the tab
        onClick(this.mInfoViewTab);
    }

