    /**
     * Method that creates an executable for expanding environment variables.
     * in a message string
     *
     * @param msg The message to expand
     * @return EchoExecutable A {@link EchoExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    EchoExecutable createEchoExecutable(String msg) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

