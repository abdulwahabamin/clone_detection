    /**
     * Method that creates an executable for create a new directory.
     *
     * @param dir The absolute path of the new directory
     * @return CreateDirExecutable A {@link CreateDirExecutable} executable implementation
     * reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    CreateDirExecutable createCreateDirectoryExecutable(String dir)
            throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

