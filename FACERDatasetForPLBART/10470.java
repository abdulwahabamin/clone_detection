    /**
     * Method that resolves a symlink to its real file system object.
     *
     * @param context The current context (needed if console == null)
     * @param symlink The link to be resolved
     * @param console The console in which execute the program. <code>null</code>
     * to attach to the default console
     * @return String The resolved link
     * @throws FileNotFoundException If the initial directory not exists
     * @throws IOException If initial directory couldn't be checked
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws ConsoleAllocException If the console can't be allocated
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @throws CommandNotFoundException If the command was not found
     * @throws OperationTimeoutException If the operation exceeded the maximum time of wait
     * @throws ExecutionException If the operation returns a invalid exit code
     * @throws CancelledOperationException If the operation was cancelled
     * @see ResolveLinkExecutable
     */
    public static FileSystemObject resolveSymlink(Context context, String symlink, Console console)
            throws FileNotFoundException, IOException, ConsoleAllocException,
            NoSuchFileOrDirectory, InsufficientPermissionsException,
            CommandNotFoundException, OperationTimeoutException,
            ExecutionException, InvalidCommandDefinitionException, CancelledOperationException {
        Console c = ensureConsole(context, console);
        ResolveLinkExecutable executable =
                c.getExecutableFactory().newCreator().createResolveLinkExecutable(symlink);
        execute(context, executable, c);
        return executable.getResult();
    }

