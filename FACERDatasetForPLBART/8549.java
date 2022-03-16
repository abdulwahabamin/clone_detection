    /**
     * Method that creates an executable for retrieve the groups of the current user.
     *
     * @return GroupsExecutable A {@link GroupsExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    GroupsExecutable createGroupsExecutable()
            throws com.cyanogenmod.filemanager.console.CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

