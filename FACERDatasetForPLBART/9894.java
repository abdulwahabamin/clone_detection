    /**
     * Method that fill the dialog with the data of the mount point.
     *
     * @param contentView The content view
     */
    private void fillData(View contentView) {
        //Get the tab views
        this.mInfoViewTab = contentView.findViewById(R.id.fso_properties_dialog_tab_info);
        this.mPermissionsViewTab =
                contentView.findViewById(R.id.fso_properties_dialog_tab_permissions);
        this.mInfoView = contentView.findViewById(R.id.fso_tab_info);
        this.mPermissionsView = contentView.findViewById(R.id.fso_tab_permissions);

        //Register the listeners
        this.mInfoViewTab.setOnClickListener(this);
        this.mPermissionsViewTab.setOnClickListener(this);

        //Gets text views
        TextView tvName = (TextView)contentView.findViewById(R.id.fso_properties_name);
        TextView tvParent = (TextView)contentView.findViewById(R.id.fso_properties_parent);
        TextView tvType = (TextView)contentView.findViewById(R.id.fso_properties_type);
        View vCategoryRow = contentView.findViewById(R.id.fso_properties_category_row);
        TextView tvCategory = (TextView)contentView.findViewById(R.id.fso_properties_category);
        View vLinkRow = contentView.findViewById(R.id.fso_properties_link_row);
        TextView tvLink = (TextView)contentView.findViewById(R.id.fso_properties_link);
        this.mTvSize = (TextView)contentView.findViewById(R.id.fso_properties_size);
        View vContatinsRow = contentView.findViewById(R.id.fso_properties_contains_row);
        this.mTvContains = (TextView)contentView.findViewById(R.id.fso_properties_contains);
        TextView tvLastAccessedTime =
                (TextView)contentView.findViewById(R.id.fso_properties_last_accessed);
        TextView tvLastModifiedTime =
                (TextView)contentView.findViewById(R.id.fso_properties_last_modified);
        TextView tvLastChangedTime =
                (TextView)contentView.findViewById(R.id.fso_properties_last_changed);
        this.mChkNoMedia = (CheckBox)contentView.findViewById(R.id.fso_include_in_media_scan);
        this.mSpnOwner = (Spinner)contentView.findViewById(R.id.fso_properties_owner);
        this.mSpnGroup = (Spinner)contentView.findViewById(R.id.fso_properties_group);
        this.mInfoMsgView = (TextView)contentView.findViewById(R.id.fso_info_msg);

        //Fill the text views
        //- Info
        tvName.setText(this.mFso.getName());
        if (FileHelper.isRootDirectory(this.mFso)) {
            tvParent.setText("-"); //$NON-NLS-1$
        } else {
            tvParent.setText(this.mFso.getParent());
        }
        tvType.setText(MimeTypeHelper.getMimeTypeDescription(this.mContext, this.mFso));
        if (this.mFso instanceof Symlink) {
            Symlink link = (Symlink)this.mFso;
            if (link.getLinkRef() != null) {
                tvLink.setText(link.getLinkRef().getFullPath());
            } else {
                tvLink.setText("-"); //$NON-NLS-1$
            }
        }
        MimeTypeCategory category = MimeTypeHelper.getCategory(this.mContext, this.mFso);
        if (category.compareTo(MimeTypeCategory.NONE) == 0) {
            vCategoryRow.setVisibility(View.GONE);
        } else {
            tvCategory.setText(
                    MimeTypeHelper.getCategoryDescription(
                            this.mContext, category));
        }
        vLinkRow.setVisibility(this.mFso instanceof Symlink ? View.VISIBLE : View.GONE);
        String size = FileHelper.getHumanReadableSize(this.mFso);
        if (size.length() == 0) {
            size = "-"; //$NON-NLS-1$
        }
        this.mTvSize.setText(size);
        this.mTvContains.setText("-");  //$NON-NLS-1$
        tvLastAccessedTime.setText(
                FileHelper.formatFileTime(this.mContext, this.mFso.getLastAccessedTime()));
        tvLastModifiedTime.setText(
                FileHelper.formatFileTime(this.mContext, this.mFso.getLastModifiedTime()));
        tvLastChangedTime.setText(
                FileHelper.formatFileTime(this.mContext, this.mFso.getLastChangedTime()));

        //- Permissions
        String loadingMsg = this.mContext.getString(R.string.loading_message);
        setSpinnerMsg(this.mContext, FsoPropertiesDialog.this.mSpnOwner, loadingMsg);
        setSpinnerMsg(this.mContext, FsoPropertiesDialog.this.mSpnGroup, loadingMsg);
        updatePermissions();

        // Load owners and groups AIDs in background
        loadAIDs();

        // Load owners and groups AIDs in background
        if (FileHelper.isDirectory(this.mFso)) {
            vContatinsRow.setVisibility(View.VISIBLE);
            if (this.mComputeFolderStatistics) {
                computeFolderUsage();
            }
        }

        // Check if permissions operations are allowed
        mIsVirtual = VirtualMountPointConsole.isVirtualStorageResource(mFso.getFullPath());
        try {
            this.mHasPrivileged = ConsoleBuilder.getConsole(this.mContext).isPrivileged();
        } catch (Throwable ex) {/**NON BLOCK**/}
        this.mSpnOwner.setEnabled(this.mHasPrivileged);
        this.mSpnGroup.setEnabled(this.mHasPrivileged);
        // Not allowed for symlinks
        if (!mIsVirtual && !(this.mFso instanceof Symlink)) {
            setCheckBoxesPermissionsEnable(this.mChkUserPermission, this.mHasPrivileged);
            setCheckBoxesPermissionsEnable(this.mChkGroupPermission, this.mHasPrivileged);
            setCheckBoxesPermissionsEnable(this.mChkOthersPermission, this.mHasPrivileged);
        } else {
            setCheckBoxesPermissionsEnable(this.mChkUserPermission, false);
            setCheckBoxesPermissionsEnable(this.mChkGroupPermission, false);
            setCheckBoxesPermissionsEnable(this.mChkOthersPermission, false);
        }
        if (!mIsVirtual && !this.mHasPrivileged && this.mIsAdvancedMode) {
            this.mInfoMsgView.setVisibility(View.VISIBLE);
            this.mInfoMsgView.setOnClickListener(this);
        }

        // Add the listener after set the value to avoid raising triggers
        this.mSpnOwner.setOnItemSelectedListener(this);
        this.mSpnGroup.setOnItemSelectedListener(this);
        setPermissionCheckBoxesListener(this.mChkUserPermission);
        setPermissionCheckBoxesListener(this.mChkGroupPermission);
        setPermissionCheckBoxesListener(this.mChkOthersPermission);

        // Check if we should show "Skip media scan" toggle
        if (!FileHelper.isDirectory(this.mFso) ||
            !StorageHelper.isPathInStorageVolume(this.mFso.getFullPath()) || this.mFso.isSecure()) {
            LinearLayout fsoSkipMediaScanView =
                    (LinearLayout)contentView.findViewById(R.id.fso_skip_media_scan_view);
            fsoSkipMediaScanView.setVisibility(View.GONE);
        } else {
            //attach the click events
            this.mChkNoMedia.setChecked(isNoMediaFilePresent());
            this.mChkNoMedia.setOnCheckedChangeListener(this);
        }

        //Change the tab
        onClick(this.mInfoViewTab);
        this.mIgnoreCheckEvents = false;
    }

