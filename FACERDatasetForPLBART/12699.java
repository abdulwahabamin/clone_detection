    /**
     * Method that retrieves the current permissions selected by the user
     *
     * @return Permissions The permissions selected by the user
     */
    private Permissions getPermissions() {
        UserPermission userPermission =
                new UserPermission(
                        this.mChkUserPermission[1].isChecked(),
                        this.mChkUserPermission[2].isChecked(),
                        this.mChkUserPermission[3].isChecked(),
                        this.mChkUserPermission[0].isChecked());
        GroupPermission groupPermission =
                new GroupPermission(
                        this.mChkGroupPermission[1].isChecked(),
                        this.mChkGroupPermission[2].isChecked(),
                        this.mChkGroupPermission[3].isChecked(),
                        this.mChkGroupPermission[0].isChecked());
        OthersPermission othersPermission =
                new OthersPermission(
                        this.mChkOthersPermission[1].isChecked(),
                        this.mChkOthersPermission[2].isChecked(),
                        this.mChkOthersPermission[3].isChecked(),
                        this.mChkOthersPermission[0].isChecked());
        Permissions permissions =
                new Permissions(userPermission, groupPermission, othersPermission);
        return permissions;
    }

