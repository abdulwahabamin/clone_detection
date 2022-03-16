    /**
     * Method that creates an executable for retrieve identity information of the current user.
     *
     * @return IdentityExecutable A {@link IdentityExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    IdentityExecutable createIdentityExecutable() throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

