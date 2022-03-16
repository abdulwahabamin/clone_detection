    /**
     * Method that load the checkboxes for a group permission
     *
     * @param ctx The current context
     * @param rootView The root view
     * @return UserPermission The user permission
     */
    private static CheckBox[] loadCheckBoxOthersPermission (
            Context ctx, View rootView, OthersPermission permission) {
        CheckBox[] chkPermissions = loadPermissionCheckBoxes(ctx, rootView, OTHERS_TYPE);
        chkPermissions[0].setChecked(permission.isStickybit());
        setCheckBoxesPermissions(chkPermissions, permission);
        return chkPermissions;
    }

