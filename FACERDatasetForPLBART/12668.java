    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.filesystem_info_dialog_tab_info:
                mIsInUsageTab = false;
                if (!this.mInfoViewTab.isSelected()) {
                    this.mInfoViewTab.setSelected(true);
                    ((TextView)this.mInfoViewTab).setTextAppearance(
                            this.mContext, R.style.primary_text_appearance);
                    this.mDiskUsageViewTab.setSelected(false);
                    ((TextView)this.mDiskUsageViewTab).setTextAppearance(
                            this.mContext, R.style.secondary_text_appearance);
                    this.mInfoView.setVisibility(View.VISIBLE);
                    this.mDiskUsageView.setVisibility(View.GONE);

                    // Apply theme
                    applyTabTheme();
                }
                this.mInfoMsgView.setVisibility(
                        this.mIsMountAllowed || !this.mIsAdvancedMode ? View.GONE : View.VISIBLE);
                mLegendLayout.setVisibility(View.INVISIBLE);
                break;

            case R.id.filesystem_info_dialog_tab_disk_usage:
                mIsInUsageTab = true;
                if (!this.mDiskUsageViewTab.isSelected()) {
                    this.mInfoViewTab.setSelected(false);
                    ((TextView)this.mInfoViewTab).setTextAppearance(
                            this.mContext, R.style.secondary_text_appearance);
                    this.mDiskUsageViewTab.setSelected(true);
                    ((TextView)this.mDiskUsageViewTab).setTextAppearance(
                            this.mContext, R.style.primary_text_appearance);
                    this.mInfoView.setVisibility(View.GONE);
                    this.mDiskUsageView.setVisibility(View.VISIBLE);

                    // Apply theme
                    applyTabTheme();
                }
                if (mIsInUsageTab) {
                    if (mLegendLayout.getVisibility() != View.VISIBLE) {
                        populateLegend();
                        mLegendLayout.setVisibility(View.VISIBLE);
                    }
                }
                this.mDiskUsageGraph.post(new Runnable() {
                    @Override
                    public void run() {
                        //Animate disk usage graph
                        FilesystemInfoDialog.this.mDiskUsageGraph.drawDiskUsage(mDiskUsage);
                    }
                });
                break;

            case R.id.filesystem_info_msg:
                mIsInUsageTab = false;
                //Change the console
                boolean superuser = ConsoleBuilder.changeToPrivilegedConsole(this.mContext);
                if (superuser) {
                    this.mInfoMsgView.setOnClickListener(null);

                    // Is filesystem able to be mounted?
                    boolean mountAllowed = MountPointHelper.isMountAllowed(this.mMountPoint);
                    if (mountAllowed) {
                        this.mInfoMsgView.setVisibility(View.GONE);
                        this.mInfoMsgView.setBackground(null);
                        this.mSwStatus.setEnabled(true);
                        this.mIsMountAllowed = true;
                        break;
                    }

                    // Show the message
                    this.mInfoMsgView.setText(
                            this.mContext.getString(
                                    R.string.filesystem_info_cant_be_mounted_msg));
                    this.mInfoMsgView.setVisibility(View.VISIBLE);
                    this.mIsMountAllowed = false;
                }
                mLegendLayout.setVisibility(View.INVISIBLE);
                break;

            default:
                mIsInUsageTab = false;
                mLegendLayout.setVisibility(View.INVISIBLE);
                break;
        }
    }

