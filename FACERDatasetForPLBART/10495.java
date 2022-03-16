    /**
     * Method that writes data to disk.
     *
     * @param context The current context (needed if console == null)
     * @param file The file where to write the data
     * @param asyncResultListener The partial result listener
     * @param console The console in which execute the program.
     * <code>null</code> to attach to the default console
     * @return WriteExecutable The command executed in background
     * @throws FileNotFoundException If the initial directory not exists
     * @throws IOException If initial directory couldn't be checked
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws ConsoleAllocException If the console can't be allocated
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @throws CommandNotFoundException If the command was not found
     * @throws OperationTimeoutException If the operation exceeded the maximum time of wait
     * @throws ExecutionException If the operation returns a invalid exit code
     * @throws ReadOnlyFilesystemException If the operation writes in a read-only filesystem
     * @throws CancelledOperationException If the operation was cancelled
     * @see WriteExecutable
     */
    public static WriteExecutable write(
            Context context, String file,
            AsyncResultListener asyncResultListener, Console console)
            throws FileNotFoundException, IOException, ConsoleAllocException,
            NoSuchFileOrDirectory, InsufficientPermissionsException,
            CommandNotFoundException, OperationTimeoutException,
            ExecutionException, InvalidCommandDefinitionException, ReadOnlyFilesystemException,
            CancelledOperationException {
        Console c = ensureConsoleForFile(context, console, file);

        // Create a wrapper listener, for unmount the filesystem if necessary
        UnmountAsyncResultListener wrapperListener = new UnmountAsyncResultListener();
        wrapperListener.mCtx = context;
        wrapperListener.mConsole = c;
        wrapperListener.mRef = asyncResultListener;

        // Prior to write to disk the data, ensure that can write to the disk using
        // createFile method
        //- Create
        CreateFileExecutable executable1 =
                c.getExecutableFactory().newCreator().createCreateFileExecutable(file);
        boolean unmount = writableExecute(context, executable1, c, true);
        if (executable1.getResult().booleanValue()) {
            // Configure the rest of attributes of the wrapper listener
            wrapperListener.mUnmount = unmount;
            wrapperListener.mMountPoint = executable1.getDstWritableMountPoint();

            //- Write
            WriteExecutable executable2 =
                    c.getExecutableFactory().newCreator().
                        createWriteExecutable(file, wrapperListener);
            execute(context, executable2, c);
            return executable2;
        }
        throw new ExecutionException(String.format("Fail to create file %s", file)); //$NON-NLS-1$
    }

