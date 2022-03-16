    /**
     * Method that makes a quick folder search for the passed expression.
     *
     * @param context The current context (needed if console == null)
     * @param regexp The expression to search
     * @param console The console in which execute the program. <code>null</code>
     * to attach to the default console
     * @return List<String> The list of directories found
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
     * @see QuickFolderSearchExecutable
     */
    public static List<String> quickFolderSearch(Context context, String regexp, Console console)
            throws FileNotFoundException, IOException, ConsoleAllocException,
            NoSuchFileOrDirectory, InsufficientPermissionsException,
            CommandNotFoundException, OperationTimeoutException,
            ExecutionException, InvalidCommandDefinitionException, CancelledOperationException {
        Console c = ensureConsole(context, console);
        QuickFolderSearchExecutable executable =
                c.getExecutableFactory().newCreator().createQuickFolderSearchExecutable(regexp);
        execute(context, executable, c);
        return executable.getResult();
    }

