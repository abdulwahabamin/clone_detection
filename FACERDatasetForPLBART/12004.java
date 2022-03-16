   /**
    * Method for execute a command in the operating system layer.
    *
    * @param executable The executable command to be executed
    * @param ctx The current context
    * @throws ConsoleAllocException If the console is not allocated
    * @throws InsufficientPermissionsException If an operation requires elevated permissions
    * @throws NoSuchFileOrDirectory If the file or directory was not found
    * @throws OperationTimeoutException If the operation exceeded the maximum time of wait
    * @throws CommandNotFoundException If the executable program was not found
    * @throws ExecutionException If the operation returns a invalid exit code
    * @throws ReadOnlyFilesystemException If the operation writes in a read-only filesystem
    * @throws CancelledOperationException If the operation was cancelled
    * @throws AuthenticationFailedException If the operation failed because an
    * authentication failure
 * @throws AuthenticationFailedException
    */
   public abstract void execute(final Executable executable, final Context ctx)
           throws ConsoleAllocException, InsufficientPermissionsException, NoSuchFileOrDirectory,
           OperationTimeoutException, ExecutionException, CommandNotFoundException,
           ReadOnlyFilesystemException, CancelledOperationException, AuthenticationFailedException;

