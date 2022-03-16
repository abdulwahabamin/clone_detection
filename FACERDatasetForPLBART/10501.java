    /**
     * Method that execute a program.
     *
     * @param context The current context (needed if console == null)
     * @param executable The executable program to execute
     * @param console The console in which execute the program. <code>null</code> to attach
     * to the default console
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws ConsoleAllocException If the console can't be allocated
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @throws CommandNotFoundException If the command was not found
     * @throws OperationTimeoutException If the operation exceeded the maximum time of wait
     * @throws ExecutionException If the operation returns a invalid exit code
     * @throws CancelledOperationException If the operation was cancelled
     * @throws AuthenticationFailedException If the operation failed caused by an
     * authentication failure
     */
    private static void execute(Context context, Executable executable, Console console)
            throws ConsoleAllocException, InsufficientPermissionsException, NoSuchFileOrDirectory,
            OperationTimeoutException, ExecutionException, CommandNotFoundException,
            CancelledOperationException, AuthenticationFailedException {
        try {
            console.execute(executable, context);
        } catch (ReadOnlyFilesystemException rofEx) {
            // ReadOnlyFilesystemException don't have sense if command is not writable
            // WritableExecutable must be used with "writableExecute" method
            throw new ExecutionException(rofEx.getMessage(), rofEx);
        }
    }

