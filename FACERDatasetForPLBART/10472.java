    /**
     * Method that retrieves the information of a file system object.
     *
     * @param context The current context (needed if console == null)
     * @param src The file system object
     * @param followSymlinks It should be follow the symlinks
     * @param console The console in which execute the program. <code>null</code>
     * to attach to the default console
     * @return FileSystemObject The file system object reference
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
    public static FileSystemObject getFileInfo(
            Context context, String src, boolean followSymlinks, Console console)
            throws FileNotFoundException, IOException, ConsoleAllocException,
            NoSuchFileOrDirectory, InsufficientPermissionsException,
            CommandNotFoundException, OperationTimeoutException,
            ExecutionException, InvalidCommandDefinitionException, CancelledOperationException {
        Console c = ensureConsoleForFile(context, console, src);
        ListExecutable executable =
                c.getExecutableFactory().
                    newCreator().createFileInfoExecutable(src, followSymlinks);
        execute(context, executable, c);
        List<FileSystemObject> files = executable.getResult();
        if (files != null && files.size() > 0) {
            // Resolve symlinks prior to return the object
            if (followSymlinks) {
                FileHelper.resolveSymlinks(context, files);
            }
            return files.get(0);
        }
        return null;
    }

