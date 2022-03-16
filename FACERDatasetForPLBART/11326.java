    /**
     * Method that execute a command
     *
     * @param cmd The command to execute
     * @param asyncResultListener The listener where to return partial results
     * @return ExecExecutable A {@link ExecExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    ExecExecutable createExecExecutable(
            String cmd, AsyncResultListener asyncResultListener) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

