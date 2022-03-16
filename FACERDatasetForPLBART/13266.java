    /**
     * Method that lists a directory.
     *
     * @param context The current context (needed if console == null)
     * @param directory The path of the directory to list
     * @param console The console in which execute the program. <code>null</code>
     * to attach to the default console
     * @return List<FileSystemObject> The list of files of the directory
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
     * @see ListExecutable
     */
    public static List<FileSystemObject> listFiles(
            Context context, String directory, Console console)
            throws FileNotFoundException, IOException, ConsoleAllocException,
            NoSuchFileOrDirectory, InsufficientPermissionsException,
            CommandNotFoundException, OperationTimeoutException,
            ExecutionException, InvalidCommandDefinitionException, CancelledOperationException,
            CancelledOperationException {
        Console c = ensureConsoleForFile(context, console, directory);
        ListExecutable executable =
                c.getExecutableFactory().newCreator().
                    createListExecutable(directory);
        execute(context, executable, c);
        List<FileSystemObject> result = executable.getResult();
        FileHelper.resolveSymlinks(context, result);

        // And now we need to verify if the directory is the
        if (VirtualMountPointConsole.isVirtualStorageDir(directory)) {
            result.addAll(VirtualMountPointConsole.getVirtualMountableDirectories());
        }

        return result;
    }

