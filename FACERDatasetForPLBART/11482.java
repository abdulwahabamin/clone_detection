    /**
     * Method that executes the program
     *
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @throws ExecutionException If the operation returns a invalid exit code
     */
    public abstract void execute()
            throws InsufficientPermissionsException, NoSuchFileOrDirectory, ExecutionException,
                   CancelledOperationException;

