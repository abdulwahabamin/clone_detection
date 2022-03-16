    /**
     * Method that archive-compress file system objects.
     *
     * @param context The current context (needed if console == null)
     * @param mode The compression mode
     * @param dst The destination compressed file
     * @param src The array of source files to compress
     * @param asyncResultListener The partial result listener
     * @param console The console in which execute the program.
     * <code>null</code> to attach to the default console
     * @return CompressExecutable The command executed in background
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
     * @see CompressExecutable
     */
    public static CompressExecutable compress(
            Context context, CompressionMode mode, String dst, String[] src,
            AsyncResultListener asyncResultListener, Console console)
            throws FileNotFoundException, IOException, ConsoleAllocException,
            NoSuchFileOrDirectory, InsufficientPermissionsException,
            CommandNotFoundException, OperationTimeoutException,
            ExecutionException, InvalidCommandDefinitionException, ReadOnlyFilesystemException,
            CancelledOperationException {
        Console c = ensureConsole(context, console);

        // Create a wrapper listener, for unmount the filesystem if necessary
        UnmountAsyncResultListener wrapperListener = new UnmountAsyncResultListener();
        wrapperListener.mCtx = context;
        wrapperListener.mConsole = c;
        wrapperListener.mRef = asyncResultListener;

        CompressExecutable executable1 =
                c.getExecutableFactory().newCreator().
                    createCompressExecutable(mode, dst, src, wrapperListener);

        // Prior to write to disk the data, ensure that can write to the disk using
        // createFile method
        //- Create
        String compressOutFile = executable1.getOutCompressedFile();
        CreateFileExecutable executable2 =
                c.getExecutableFactory().
                    newCreator().
                        createCreateFileExecutable(compressOutFile);
        boolean unmount = writableExecute(context, executable2, c, true);
        if (executable2.getResult().booleanValue()) {
            // Configure the rest of attributes of the wrapper listener
            wrapperListener.mUnmount = unmount;
            wrapperListener.mMountPoint = executable2.getDstWritableMountPoint();

            // Some archive modes requires a new file. Ensure that the created
            // file doesn't exists
            DeleteFileExecutable executable3 =
                                c.getExecutableFactory().
                                    newCreator().
                                        createDeleteFileExecutable(compressOutFile);
            writableExecute(context, executable3, c, true);
            if (executable3.getResult().booleanValue()) {
                //- Compress
                execute(context, executable1, c);
                return executable1;
            }
        }
        throw new ExecutionException(
                String.format("Fail to create file %s", compressOutFile)); //$NON-NLS-1$
    }

