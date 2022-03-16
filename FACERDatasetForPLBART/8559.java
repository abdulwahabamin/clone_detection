    /**
     * Method that creates an executable for retrieve operating system process identifiers of a
     * shell.
     *
     * @param pid The shell process id where the process is running
     * @param processName The process name
     * @return ProcessIdExecutable A {@link ProcessIdExecutable} executable implementation
     * reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    ProcessIdExecutable createProcessIdExecutable(int pid) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

