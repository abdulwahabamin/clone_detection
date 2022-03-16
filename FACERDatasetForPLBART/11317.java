    /**
     * Method that creates an executable for change the permissions of a file system object.
     *
     * @param fso The absolute path to the source file system object
     * @param newPermissions The new permissions of the file system object
     * @return ChangePermissionsExecutable A {@link ChangePermissionsExecutable} executable
     * implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    ChangePermissionsExecutable createChangePermissionsExecutable(
            String fso, Permissions newPermissions) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

