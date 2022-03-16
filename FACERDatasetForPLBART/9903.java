    /**
     * {@inheritDoc}
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        User user = null;
        Group group = null;
        String msg = null;

        try {
            // Apply theme
            Theme theme = ThemeManager.getCurrentTheme(this.mContext);
            theme.setTextColor(
                    this.mContext, ((TextView) parent.getChildAt(0)), "text_color"); //$NON-NLS-1$

            String row = parent.getItemAtPosition(position).toString();
            int uid = Integer.parseInt(row.substring(0, row.indexOf(AID_SEPARATOR)));
            String name = row.substring(row.indexOf(AID_SEPARATOR) + 3);

            // Check which spinner was changed
            switch (parent.getId()) {
                case R.id.fso_properties_owner:
                    //Owner
                    user = new User(uid, name);
                    group = this.mFso.getGroup();
                    msg = this.mContext.getString(
                            R.string.fso_properties_failed_to_change_owner_msg);
                    break;
                case R.id.fso_properties_group:
                    //Group
                    user = this.mFso.getUser();
                    group = new Group(uid, name);
                    msg = this.mContext.getString(
                            R.string.fso_properties_failed_to_change_group_msg);
                    break;

                default:
                    break;
            }
        } catch (Exception ex) {
            // Capture the exception
            ExceptionUtil.translateException(this.mContext, ex);

            // Exit from dialog. The dialog may have inconsistency
            this.mDialog.dismiss();
            return;
        }

        // Has changed?
        if (this.mFso.getUser().compareTo(user) == 0 &&
             this.mFso.getGroup().compareTo(group) == 0) {
            return;
        }

        // Cancel the folder usage command
        cancelFolderUsageCommand();

        // Change the owner and group of the fso
        try {
            if (!CommandHelper.changeOwner(
                    this.mContext, this.mFso.getFullPath(), user, group, null)) {
                // Show the warning message
                setMsg(msg);

                // Update the information of owner and group
                updateSpinnerFromAid(this.mSpnOwner, this.mFso.getUser());
                updateSpinnerFromAid(this.mSpnGroup, this.mFso.getGroup());
                return;
            }

            //Change the fso reference
            this.mFso.setUser(user);
            this.mFso.setGroup(group);
            this.mHasChanged = true;
            setMsg(null);

        } catch (Exception ex) {
            // Capture the exception and show warning message
            final String txtMsg = msg;
            ExceptionUtil.translateException(
                    this.mContext, ex, true, true, new ExceptionUtil.OnRelaunchCommandResult() {
                @Override
                public void onSuccess() {
                    // Hide the message
                    setMsg(null);
                }

                @Override
                public void onCancelled() {
                    // Update the information of owner and group
                    updateSpinnerFromAid(
                            FsoPropertiesDialog.this.mSpnOwner,
                            FsoPropertiesDialog.this.mFso.getUser());
                    updateSpinnerFromAid(
                            FsoPropertiesDialog.this.mSpnGroup,
                            FsoPropertiesDialog.this.mFso.getGroup());
                    setMsg(null);
                }

                @Override
                public void onFailed(Throwable cause) {
                    setMsg(txtMsg);

                    // Update the information of owner and group
                    updateSpinnerFromAid(
                            FsoPropertiesDialog.this.mSpnOwner,
                            FsoPropertiesDialog.this.mFso.getUser());
                    updateSpinnerFromAid(
                            FsoPropertiesDialog.this.mSpnGroup,
                            FsoPropertiesDialog.this.mFso.getGroup());
                    return;
                }
            });

        }
    }

