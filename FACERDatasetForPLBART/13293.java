    /**
     * Method that execute a program that requires write permissions over the filesystem. This
     * method ensure mount/unmount the filesystem before/after executing the operation.
     *
     * @param context The current context (needed if console == null)
     * @param executable The writable executable program to execute
     * @param console The console in which execute the program. <code>null</code> to attach
     * to the default console
     * @param leaveDeviceMounted If the operation must leave the filesystem mounted after
     * the execution
     * @return boolean If the filesystem was left unmount
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws ConsoleAllocException If the console can't be allocated
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @throws CommandNotFoundException If the command was not found
     * @throws OperationTimeoutException If the operation exceeded the maximum time of wait
     * @throws ExecutionException If the operation returns a invalid exit code
     * @throws ReadOnlyFilesystemException If the operation writes in a read-only filesystem
     * @throws CancelledOperationException If the operation was cancelled
     * @throws AuthenticationFailedException If the operation failed caused by an
     * authentication failure
     */
    private static boolean writableExecute(Context context, WritableExecutable executable,
            Console console, boolean leaveDeviceMounted) throws ConsoleAllocException,
            InsufficientPermissionsException, NoSuchFileOrDirectory, OperationTimeoutException,
            ExecutionException, CommandNotFoundException, ReadOnlyFilesystemException,
            CancelledOperationException, AuthenticationFailedException {

        //Retrieve the mount point information to check if a remount operation is required
        //There are 2 mount points: destination and source. Check both
        // - Destination
        boolean needMountDst = false;
        MountPoint mpDst = executable.getDstWritableMountPoint();
        if (mpDst != null) {
            if (MountPointHelper.isMountAllowed(mpDst)) {
                if (!MountPointHelper.isReadWrite(mpDst)) {
                    needMountDst = true;
                } else {
                    //Mount point is already read-write
                }
            } else {
                //For security or physical reasons the mount point can't be
                //mounted as read-write. Execute the command
                //and notify to the user
            }
        } else {
            //Don't have information about the mount point. Execute the command
            //and notify to the user
        }
        // - Source
        boolean needMountSrc = false;
        MountPoint mpSrc = executable.getSrcWritableMountPoint();
        if (mpSrc != null) {
            if (MountPointHelper.isMountAllowed(mpSrc)) {
                if (!MountPointHelper.isReadWrite(mpSrc)) {
                    needMountSrc = true;
                } else {
                    //Mount point is already read-write
                }
            } else {
                //For security or physical reasons the mount point can't be
                //mounted as read-write. Execute the command
                //and notify to the user
            }
        } else {
            //Don't have information about the mount point. Execute the command
            //and notify to the user
        }

        //Create the mount/unmount executables
        MountExecutable mountDstExecutable = null;
        MountExecutable unmountDstExecutable = null;
        if (needMountDst) {
            mountDstExecutable =
                    console.getExecutableFactory().newCreator().
                        createMountExecutable(mpDst, true);
            unmountDstExecutable =
                    console.getExecutableFactory().newCreator().
                        createMountExecutable(mpDst, false);
        }
        MountExecutable mountSrcExecutable = null;
        MountExecutable unmountSrcExecutable = null;
        if (needMountSrc) {
            mountSrcExecutable =
                    console.getExecutableFactory().newCreator().
                        createMountExecutable(mpSrc, true);
            unmountSrcExecutable =
                    console.getExecutableFactory().newCreator().
                        createMountExecutable(mpSrc, false);
        }

        //Execute the commands
        boolean mountExecutedDst = false;
        boolean mountExecutedSrc = false;
        try {
            if (needMountDst) {
                //Execute the mount command
                console.execute(mountDstExecutable, context);
                mountExecutedDst = true;
            }
            if (needMountSrc) {
                //Execute the mount command
                console.execute(mountSrcExecutable, context);
                mountExecutedSrc = true;
            }

            //Execute the command
            console.execute(executable, context);

        } catch (InsufficientPermissionsException ipEx) {
            //Configure the commands to execute
            if (needMountDst && !mountExecutedDst) {
                //The failed operation was the mount rw operation
                //This operations is already in the exception in the fifo queue
                ipEx.addExecutable(executable);
            } else if (needMountSrc && !mountExecutedSrc) {
                //The failed operation was the mount rw operation
                //This operations is already in the exception in the fifo queue
                ipEx.addExecutable(executable);
            }
            if (needMountDst) {
                //A mount operation was executed or will be executed
                ipEx.addExecutable(unmountDstExecutable);
            }
            if (needMountSrc) {
                //A mount operation was executed or will be executed
                ipEx.addExecutable(unmountSrcExecutable);
            }

            //Rethrow the exception
            throw ipEx;

        } finally {
            //If previously was a mount successful execution, then execute
            //and unmount operation
            if (mountExecutedDst && !leaveDeviceMounted) {
                //Execute the unmount command
                console.execute(unmountDstExecutable, context);
            }
            if (mountExecutedSrc && !leaveDeviceMounted) {
                //Execute the unmount command
                console.execute(unmountSrcExecutable, context);
            }
        }

        // If the needed unmount was executed
        return (mountExecutedDst || mountExecutedSrc) && leaveDeviceMounted;
    }

