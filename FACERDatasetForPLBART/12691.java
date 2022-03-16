    /**
     * Method that refresh the information of permissions
     * @hide
     */
    void updatePermissions() {
        // Update the permissions with the previous information
        FsoPropertiesDialog.this.mIgnoreCheckEvents = true;
        try {
            Permissions permissions = this.mFso.getPermissions();
            this.mChkUserPermission =
                    loadCheckBoxUserPermission(
                            this.mContext, this.mContentView, permissions.getUser());
            this.mChkGroupPermission =
                    loadCheckBoxGroupPermission(
                            this.mContext, this.mContentView, permissions.getGroup());
            this.mChkOthersPermission =
                    loadCheckBoxOthersPermission(
                            this.mContext, this.mContentView, permissions.getOthers());
        } finally {
            FsoPropertiesDialog.this.mIgnoreCheckEvents = false;
        }
    }

