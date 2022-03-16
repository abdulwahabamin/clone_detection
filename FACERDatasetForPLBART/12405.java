    /**
     * Method that returns the default permissions for folder
     *
     * @return Permissions The default permissions for folder
     */
    public static Permissions createDefaultFilePermissions() {
        return new Permissions(
                new UserPermission(true, true, false, false),
                new GroupPermission(true, true, false, false),
                new OthersPermission(false, false, false, false));
    }

