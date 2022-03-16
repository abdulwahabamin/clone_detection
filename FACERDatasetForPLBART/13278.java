    /**
     * Method that re-mounts a filesystem from his mount point info.
     *
     * @param context The current context (needed if console == null)
     * @param mp The mount point to re-mount
     * @param rw Indicates if the operation re-mounted the device as read-write
     * @param console The console in which execute the program. <code>null</code>
     * to attach to the default console
     * @return boolean The operation result
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
     * @see MountExecutable
     */
    public static boolean remount(Context context, MountPoint mp, boolean rw, Console console)
            throws FileNotFoundException, IOException, ConsoleAllocException,
            NoSuchFileOrDirectory, InsufficientPermissionsException,
            CommandNotFoundException, OperationTimeoutException,
            ExecutionException, InvalidCommandDefinitionException, CancelledOperationException {
        boolean ret = false;
        if (mp.isSecure()) {
            // Unmount the secure file system
            SecureConsole sc = (SecureConsole) ensureConsoleForFile(
                    context, console, mp.getMountPoint());
            if (rw) {
                sc.mount(context);
            } else {
                sc.unmount();
            }
            ret = true;
        } else {
            Console c = ensureConsole(context, console);
            MountExecutable executable =
                    c.getExecutableFactory().newCreator().createMountExecutable(mp, rw);
            execute(context, executable, c);
            ret = executable.getResult().booleanValue();
        }

        if (ret) {
            // Send an broadcast to notify that the mount state of this filesystem changed
            Intent intent = new Intent(FileManagerSettings.INTENT_MOUNT_STATUS_CHANGED);
            intent.putExtra(FileManagerSettings.EXTRA_MOUNTPOINT, mp.getMountPoint());
            intent.putExtra(FileManagerSettings.EXTRA_STATUS, rw
                    ? MountExecutable.READWRITE : MountExecutable.READONLY);
            context.sendBroadcast(intent);
        }

        return ret;
    }

