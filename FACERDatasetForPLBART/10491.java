    /**
     * Method that retrieves the process identifier of a process (a program
     * owned by the main process of this application).
     *
     * @param context The current context (needed if console == null)
     * @param pid The process id of the shell where the command is running
     * @param processName The process name
     * @param console The console in which execute the program. <code>null</code>
     * to attach to the default console
     * @return Integer The process identifier of the program or <code>null</code> if not exists
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
     * @see ProcessIdExecutable
     */
    public static Integer getProcessId(
            Context context, int pid, String processName, Console console)
            throws FileNotFoundException, IOException, ConsoleAllocException,
            NoSuchFileOrDirectory, InsufficientPermissionsException,
            CommandNotFoundException, OperationTimeoutException,
            ExecutionException, InvalidCommandDefinitionException, CancelledOperationException {
        Console c = ensureConsole(context, console);
        ProcessIdExecutable executable =
                c.getExecutableFactory().newCreator().createProcessIdExecutable(pid, processName);
        execute(context, executable, c);
        List<Integer> pids = executable.getResult();
        if (pids != null && pids.size() > 0) {
            return pids.get(0);
        }
        return null;
    }

