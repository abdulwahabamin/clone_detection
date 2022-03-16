    /**
     * Method that execute a program that requires write permissions over the filesystem. This
     * method ensure mount/unmount the filesystem before/after executing the operation.
     *
     * @param context The current context (needed if console == null)
     * @param executable The writable executable program to execute
     * @param console The console in which execute the program. <code>null</code> to attach
     * to the default console
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws ConsoleAllocException If the console can't be allocated
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @throws CommandNotFoundException If the command was not found
     * @throws OperationTimeoutException If the operation exceeded the maximum time of wait
     * @throws ExecutionException If the operation returns a invalid exit code
     * @throws ReadOnlyFilesystemException If the operation writes in a read-only filesystem
     * @throws CancelledOperationException If the operation was cancelled
     * @throws AuthenticationFailedException If the operation failed caused by an
     * authentication failure
     */
    private static void writableExecute(Context context, WritableExecutable executable,
            Console console) throws ConsoleAllocException, InsufficientPermissionsException,
            NoSuchFileOrDirectory, OperationTimeoutException, ExecutionException,
            CommandNotFoundException, ReadOnlyFilesystemException, CancelledOperationException,
            AuthenticationFailedException{
        writableExecute(context, executable, console, false);
    }

