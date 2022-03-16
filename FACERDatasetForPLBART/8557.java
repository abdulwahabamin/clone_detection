    /**
     * Method that creates an executable for retrieve the parent directory
     * of a file system object.
     *
     * @param fso The absolute path to the file system object
     * @return ParentDirExecutable A {@link ParentDirExecutable} executable implementation
     * reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    ParentDirExecutable createParentDirExecutable(String fso) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

