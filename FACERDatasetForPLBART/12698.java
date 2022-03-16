    /**
     * Method that sets the listener for the permission checkboxes
     *
     * @param chkPermissions The checkboxes
     */
    private void setPermissionCheckBoxesListener(CheckBox[] chkPermissions) {
        int cc = chkPermissions.length;
        for (int i = 0; i < cc; i++) {
            chkPermissions[i].setOnCheckedChangeListener(this);
        }
    }

