    /**
     * Method that creates an executable for create a new file.
     *
     * @param file The absolute path of the new file
     * @return CreateFileExecutable A {@link CreateFileExecutable} executable
     * implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    CreateFileExecutable createCreateFileExecutable(String file) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

