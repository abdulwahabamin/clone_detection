    /**
     * Method that check/uncheck the common permission for a permission checkboxes
     *
     * @param chkPermissions The checkboxes
     * @param enabled If the checkbox should be enabled
     */
    private static void setCheckBoxesPermissionsEnable (
            CheckBox[] chkPermissions, boolean enabled) {
        int cc = chkPermissions.length;
        for (int i = 0; i < cc; i++) {
            chkPermissions[i].setEnabled(enabled);
        }
    }

