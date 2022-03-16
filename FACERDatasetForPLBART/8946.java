    /**
     * Method that checks if the result code of the execution was successfully.
     *
     * @param exitCode Program exit code
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @throws CommandNotFoundException If the command was not found
     * @throws ExecutionException If the operation returns a invalid exit code
     * @hide
     */
    public abstract void checkExitCode(int exitCode)
            throws InsufficientPermissionsException, CommandNotFoundException,
            ExecutionException;

