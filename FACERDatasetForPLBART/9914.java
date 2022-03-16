    /**
     * Method that load the checkboxes associated with a type of permission
     *
     * @param ctx The current context
     * @param rootView The root view
     * @param type The type of permission [owner, group, others]
     * @return CheckBox[] The checkboxes associated
     */
    private static CheckBox[] loadPermissionCheckBoxes(Context ctx, View rootView, String type) {
        Resources res = ctx.getResources();
        CheckBox[] chkPermissions = new CheckBox[4];
        chkPermissions[0] = (CheckBox)rootView.findViewById(
                ResourcesHelper.getIdentifier(
                        res, "id",  //$NON-NLS-1$
                        String.format("fso_permissions_%s_special", type))); //$NON-NLS-1$
        chkPermissions[1] = (CheckBox)rootView.findViewById(
                ResourcesHelper.getIdentifier(
                        res, "id",  //$NON-NLS-1$
                        String.format("fso_permissions_%s_read", type))); //$NON-NLS-1$
        chkPermissions[2] = (CheckBox)rootView.findViewById(
                ResourcesHelper.getIdentifier(
                        res, "id",  //$NON-NLS-1$
                        String.format("fso_permissions_%s_write", type))); //$NON-NLS-1$
        chkPermissions[3] = (CheckBox)rootView.findViewById(
                ResourcesHelper.getIdentifier(
                        res, "id",  //$NON-NLS-1$
                        String.format("fso_permissions_%s_execute", type))); //$NON-NLS-1$
        return chkPermissions;
    }

