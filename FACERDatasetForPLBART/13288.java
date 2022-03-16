    /**
     * Method that uncompress file system objects.
     *
     * @param context The current context (needed if console == null)
     * @param src The file to compress
     * @param dst The destination file of folder (if null this method resolve with the best
     * fit based on the src)
     * @param asyncResultListener The partial result listener
     * @param console The console in which execute the program.
     * <code>null</code> to attach to the default console
     * @return UncompressExecutable The command executed in background
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
    public static UncompressExecutable uncompress(
            Context context, String src, String dst,
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

        UncompressExecutable executable1 =
                c.getExecutableFactory().newCreator().
                    createUncompressExecutable(src, dst, wrapperListener);

        // Prior to write to disk the data, ensure that can write to the disk using
        // createFile or createFolder method

        String compressOutFile = executable1.getOutUncompressedFile();
        WritableExecutable executable2 = null;
        if (executable1.IsArchive()) {
            //- Create Folder
            executable2 =
                    c.getExecutableFactory().
                        newCreator().
                            createCreateDirectoryExecutable(compressOutFile);
        } else {
            //- Create File
            executable2 =
                    c.getExecutableFactory().
                        newCreator().
                            createCreateFileExecutable(compressOutFile);
        }
        boolean unmount = writableExecute(context, executable2, c, true);
        if (((Boolean)executable2.getResult()).booleanValue()) {
            // Configure the rest of attributes of the wrapper listener
            wrapperListener.mUnmount = unmount;
            wrapperListener.mMountPoint = executable2.getDstWritableMountPoint();

            //- Compress
            execute(context, executable1, c);

            // Do media scan
            MediaScannerConnection.scanFile(context, new String[]{
                    MediaHelper.normalizeMediaPath(compressOutFile)}, null, null);

            return executable1;
        }
        throw new ExecutionException(
                String.format("Fail to uncompress to %s", compressOutFile)); //$NON-NLS-1$
    }

