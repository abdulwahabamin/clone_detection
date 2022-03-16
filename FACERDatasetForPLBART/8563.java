    /**
     * Method that creates an executable for resolves the real
     * path of a symlink or file system object.
     *
     * @param fso The absolute path to the file system object
     * @return ResolveLinkExecutable A {@link ResolveLinkExecutable} executable
     * implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    ResolveLinkExecutable createResolveLinkExecutable(String fso) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

