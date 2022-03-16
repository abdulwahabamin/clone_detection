    /**
     * Method that check/uncheck the common permission for a permission checkboxes
     *
     * @param chkPermissions The checkboxes
     * @param permission The permission
     */
    private static void setCheckBoxesPermissions (
            CheckBox[] chkPermissions, Permission permission) {
        chkPermissions[1].setChecked(permission.isRead());
        chkPermissions[2].setChecked(permission.isWrite());
        chkPermissions[3].setChecked(permission.isExecute());
    }

