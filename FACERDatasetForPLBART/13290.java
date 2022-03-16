    /**
     * Method that re-execute the command.
     *
     * @param context The current context (needed if console == null)
     * @param executable The executable program to execute
     * @param console The console in which execute the program. <code>null</code>
     * to attach to the default console
     * @return Object The result of the re-execution
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws ConsoleAllocException If the console can't be allocated
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @throws CommandNotFoundException If the command was not found
     * @throws OperationTimeoutException If the operation exceeded the maximum time of wait
     * @throws ExecutionException If the operation returns a invalid exit code
     * @throws ReadOnlyFilesystemException If the operation writes in a read-only filesystem
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     * @throws IOException If initial directory couldn't be checked
     * @throws CancelledOperationException If the operation was cancelled
     * @throws FileNotFoundException If the initial directory not exists
     */
    public static Object reexecute(
            Context context , SyncResultExecutable executable, Console console)
            throws ConsoleAllocException, InsufficientPermissionsException, NoSuchFileOrDirectory,
            OperationTimeoutException, ExecutionException,
            CommandNotFoundException, ReadOnlyFilesystemException,
            FileNotFoundException, IOException, InvalidCommandDefinitionException,
            CancelledOperationException {
        Console c = ensureConsole(context, console);
        c.execute(executable, context);
        return executable.getResult();
    }

