    /**
     * Method that load the checkboxes for a user permission
     *
     * @param ctx The current context
     * @param rootView The root view
     * @return UserPermission The user permission
     */
    private static CheckBox[] loadCheckBoxUserPermission (
            Context ctx, View rootView, UserPermission permission) {
        CheckBox[] chkPermissions = loadPermissionCheckBoxes(ctx, rootView, OWNER_TYPE);
        chkPermissions[0].setChecked(permission.isSetUID());
        setCheckBoxesPermissions(chkPermissions, permission);
        return chkPermissions;
    }

