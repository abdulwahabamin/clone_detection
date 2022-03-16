    /**
     * Method that retrieves the disk usage of all mount points.
     *
     * @param context The current context (needed if console == null)
     * @param dir The directory of which obtain its disk usage
     * @param console The console in which execute the program. <code>null</code>
     * to attach to the default console
     * @return DiskUsage The disk usage information
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
    public static DiskUsage getDiskUsage(Context context, String dir, Console console)
            throws FileNotFoundException, IOException, ConsoleAllocException,
            NoSuchFileOrDirectory, InsufficientPermissionsException,
            CommandNotFoundException, OperationTimeoutException,
            ExecutionException, InvalidCommandDefinitionException, CancelledOperationException {

        // Virtual directories don't implement a disk usage command, just return the data if
        // the directory belongs to a virtual filesystem
        VirtualMountPointConsole vc = VirtualMountPointConsole.getVirtualConsoleForPath(dir);
        if (vc != null) {
            return vc.getDiskUsage(dir);
        } else {
            Console c = ensureConsole(context, console);
            DiskUsageExecutable executable =
                    c.getExecutableFactory().newCreator().createDiskUsageExecutable(dir);
            execute(context, executable, c);
            List<DiskUsage> du = executable.getResult();
            for (DiskUsage d : du) {
                if (d.getMountPoint().equals(dir)) {
                    return d;
                }
            }
        }
        return null;
    }

