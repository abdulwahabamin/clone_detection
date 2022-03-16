    /**
     * Method that creates an executable for retrieve operating system process identifier of a
     * shell.
     *
     * @return ProcessIdExecutable A {@link ProcessIdExecutable} executable implementation
     * reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    ProcessIdExecutable createShellProcessIdExecutable() throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

