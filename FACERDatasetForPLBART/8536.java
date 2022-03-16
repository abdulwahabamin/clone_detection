    /**
     * Method that creates an executable for change the owner of a file system object.
     *
     * @param fso The absolute path to the source file system object
     * @param newUser The new user of the file system object
     * @param newGroup The new group of the file system object
     * @return ChangeOwnerExecutable A {@link ChangeOwnerExecutable} executable
     * implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    ChangeOwnerExecutable createChangeOwnerExecutable(
            String fso, User newUser, Group newGroup) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

