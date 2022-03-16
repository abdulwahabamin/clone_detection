    /**
     * Method that manage a check changed event
     *
     * @param buttonView The checkbox
     * @param isChecked If the checkbox is checked
     */
    private void onPermissionsCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (this.mIgnoreCheckEvents) return;
        try {
            // Cancel the folder usage command
            cancelFolderUsageCommand();

            // Retrieve the permissions and send to operating system
            Permissions permissions = getPermissions();
            if (!CommandHelper.changePermissions(
                    this.mContext, this.mFso.getFullPath(), permissions, null)) {
                // Show the warning message
                setMsg(this.mContext.getString(
                        R.string.fso_properties_failed_to_change_permission_msg));

                // Update the permissions with the previous information
                updatePermissions();
                return;
            }

            // Some filesystem, like sdcards, doesn't allow to change the permissions.
            // But the system doesn't return the fail. Read again the fso and compare to
            // ensure that the permission was changed
            try {
                FileSystemObject systemFso  =
                        CommandHelper.getFileInfo(
                                this.mContext, this.mFso.getFullPath(), false, null);
                if (systemFso == null || systemFso.getPermissions().compareTo(permissions) != 0) {
                    // Show the warning message
                    setMsg(FsoPropertiesDialog.this.mContext.getString(
                            R.string.fso_properties_failed_to_change_permission_msg));

                    // Update the permissions with the previous information
                    updatePermissions();
                    return;
                }
            } catch (Exception e) {
                // Show the warning message
                setMsg(FsoPropertiesDialog.this.mContext.getString(
                        R.string.fso_properties_failed_to_change_permission_msg));

                // Update the permissions with the previous information
                updatePermissions();
                return;
            }

            // The permission was changed. Refresh the information
            this.mFso.setPermissions(permissions);
            this.mHasChanged = true;
            setMsg(null);

        } catch (Exception ex) {
            // Capture the exception and show warning message
            ExceptionUtil.translateException(
                    this.mContext, ex, true, true, new ExceptionUtil.OnRelaunchCommandResult() {
                @Override
                public void onSuccess() {
                    // Hide the message
                    setMsg(null);
                }

                @Override
                public void onCancelled() {
                    // Update the permissions with the previous information
                    updatePermissions();
                    setMsg(null);
                }

                @Override
                public void onFailed(Throwable cause) {
                    // Show the warning message
                    setMsg(FsoPropertiesDialog.this.mContext.getString(
                            R.string.fso_properties_failed_to_change_permission_msg));

                    // Update the permissions with the previous information
                    updatePermissions();
                }
            });
        }
    }

