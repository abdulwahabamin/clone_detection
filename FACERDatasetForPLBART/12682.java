    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fso_properties_dialog_tab_info:
                if (!this.mInfoViewTab.isSelected()) {
                    this.mInfoViewTab.setSelected(true);
                    ((TextView)this.mInfoViewTab).setTextAppearance(
                            this.mContext, R.style.primary_text_appearance);
                    this.mPermissionsViewTab.setSelected(false);
                    ((TextView)this.mPermissionsViewTab).setTextAppearance(
                            this.mContext, R.style.secondary_text_appearance);
                    this.mInfoView.setVisibility(View.VISIBLE);
                    this.mPermissionsView.setVisibility(View.GONE);

                    // Apply the them
                    applyTabTheme();
                }
                break;

            case R.id.fso_properties_dialog_tab_permissions:
                if (!this.mPermissionsViewTab.isSelected()) {
                    this.mInfoViewTab.setSelected(false);
                    ((TextView)this.mInfoViewTab).setTextAppearance(
                            this.mContext, R.style.secondary_text_appearance);
                    this.mPermissionsViewTab.setSelected(true);
                    ((TextView)this.mPermissionsViewTab).setTextAppearance(
                            this.mContext, R.style.primary_text_appearance);
                    this.mInfoView.setVisibility(View.GONE);
                    this.mPermissionsView.setVisibility(View.VISIBLE);

                    // Apply the them
                    applyTabTheme();
                }
                this.mInfoMsgView.setVisibility(
                        mIsVirtual || this.mHasPrivileged || !this.mIsAdvancedMode
                        ? View.GONE : View.VISIBLE);
                break;

            case R.id.fso_info_msg:
                //Change the console
                boolean superuser = ConsoleBuilder.changeToPrivilegedConsole(this.mContext);
                if (superuser) {
                    this.mInfoMsgView.setOnClickListener(null);
                    this.mInfoMsgView.setVisibility(View.GONE);
                    this.mInfoMsgView.setBackground(null);

                    // Enable controls
                    this.mSpnOwner.setEnabled(true);
                    this.mSpnGroup.setEnabled(true);
                    setCheckBoxesPermissionsEnable(this.mChkUserPermission, true);
                    setCheckBoxesPermissionsEnable(this.mChkGroupPermission, true);
                    setCheckBoxesPermissionsEnable(this.mChkOthersPermission, true);
                    // Not allowed for symlinks
                    if (!(this.mFso instanceof Symlink)) {
                        setCheckBoxesPermissionsEnable(this.mChkUserPermission, true);
                        setCheckBoxesPermissionsEnable(this.mChkGroupPermission, true);
                        setCheckBoxesPermissionsEnable(this.mChkOthersPermission, true);
                    }
                    this.mHasPrivileged = true;
                }
                break;

            default:
                break;
        }
    }

