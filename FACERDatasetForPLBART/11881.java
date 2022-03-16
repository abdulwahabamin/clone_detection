    /**
     * Method that checks if the standard errors has exceptions.
     *
     * @param exitCode Program exit code
     * @param err Standard Error buffer
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws CommandNotFoundException If the command was not found
     * @throws ExecutionException If the another exception is detected in the standard error
     * @hide
     */
    public void checkStdErr(int exitCode, String err)
            throws InsufficientPermissionsException, NoSuchFileOrDirectory,
            CommandNotFoundException, ExecutionException {
        /**NON BLOCK**/
    }

