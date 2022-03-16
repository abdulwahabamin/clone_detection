    /**
     * Method that returns the default permissions for folder
     *
     * @return Permissions The default permissions for folder
     */
    public static Permissions createDefaultFolderPermissions() {
        return new Permissions(
                new UserPermission(true, true, true, false),
                new GroupPermission(true, false, true, false),
                new OthersPermission(false, false, false, false));
    }

