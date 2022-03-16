    /**
     * Method that retrieves the disk usage of all the mount points.
     *
     * @param context The current context (needed if console == null)
     * @param console The console in which execute the program. <code>null</code>
     * to attach to the default console
     * @return List<DiskUsage> The disk usage of all the mount points
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
     * @see DiskUsageExecutable
     */
    public static List<DiskUsage> getDiskUsage(Context context, Console console)
            throws FileNotFoundException, IOException, ConsoleAllocException,
            NoSuchFileOrDirectory, InsufficientPermissionsException,
            CommandNotFoundException, OperationTimeoutException,
            ExecutionException, InvalidCommandDefinitionException, CancelledOperationException {
        Console c = ensureConsole(context, console);
        DiskUsageExecutable executable =
                c.getExecutableFactory().newCreator().createDiskUsageExecutable();
        execute(context, executable, c);
        List<DiskUsage> diskUsage = executable.getResult();
        diskUsage.addAll(VirtualMountPointConsole.getVirtualDiskUsage());
        return diskUsage;
    }

