    /**
     * Method that does a search in a directory tree seeking for some terms.
     *
     * @param context The current context (needed if console == null)
     * @param directory The "absolute" directory where start the search
     * @param search The terms to be searched
     * @param asyncResultListener The partial result listener
     * @param console The console in which execute the program.
     * <code>null</code> to attach to the default console
     * @return FindExecutable The command executed in background
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
     * @see SearchResult
     * @see FindExecutable
     */
    public static FindExecutable findFiles(
            Context context, String directory, Query search,
            ConcurrentAsyncResultListener asyncResultListener, Console console)
            throws FileNotFoundException, IOException, ConsoleAllocException,
            NoSuchFileOrDirectory, InsufficientPermissionsException,
            CommandNotFoundException, OperationTimeoutException,
            ExecutionException, InvalidCommandDefinitionException, CancelledOperationException {
        List<Console> consoles = new ArrayList<Console>();
        List<FindExecutable> executables = new ArrayList<FindExecutable>();
        Console c = ensureConsoleForFile(context, console, directory);
        consoles.add(c);

        // Obtain all the rest of console that will participate in the search, that aren't the
        // current console
        List<Console> vcs = VirtualMountPointConsole.getVirtualConsoleForSearchPath(directory);
        for (int i = vcs.size() - 1; i >= 0; i--) {
            Console vc = vcs.get(i);
            if (vc.equals(c)) {
                vcs.remove(i);
            }
        }
        consoles.addAll(vcs);

        // Register all the executables
        for (Console cc : consoles) {
            executables.add(
                    cc.getExecutableFactory().newCreator().
                        createFindExecutable(directory, search, asyncResultListener));
        }

        // Launch every executable
        int count = executables.size();
        for (int i = 0; i < count; i++) {
            execute(context, executables.get(i), consoles.get(i));
        }

        // Return the first of the executables
        return executables.get(0);
    }

