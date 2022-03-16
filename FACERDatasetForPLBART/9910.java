    /**
     * Method that load the checkboxes for a group permission
     *
     * @param ctx The current context
     * @param rootView The root view
     * @return UserPermission The user permission
     */
    private static CheckBox[] loadCheckBoxGroupPermission (
            Context ctx, View rootView, GroupPermission permission) {
        CheckBox[] chkPermissions = loadPermissionCheckBoxes(ctx, rootView, GROUP_TYPE);
        chkPermissions[0].setChecked(permission.isSetGID());
        setCheckBoxesPermissions(chkPermissions, permission);
        return chkPermissions;
    }

