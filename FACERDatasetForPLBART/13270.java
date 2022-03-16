    /**
     * Method that moves a file system object.
     *
     * @param context The current context (needed if console == null)
     * @param src The file system object to move
     * @param dst The destination file system object
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
     * @throws ReadOnlyFilesystemException If the operation writes in a read-only filesystem
     * @throws CancelledOperationException If the operation was cancelled
     * @see MoveExecutable
     */
    public static boolean move(Context context, String src, String dst, Console console)
            throws FileNotFoundException, IOException, ConsoleAllocException,
            NoSuchFileOrDirectory, InsufficientPermissionsException,
            CommandNotFoundException, OperationTimeoutException,
            ExecutionException, InvalidCommandDefinitionException, ReadOnlyFilesystemException,
            CancelledOperationException {

        Console cSrc = ensureConsoleForFile(context, console, src);
        Console cDst = ensureConsoleForFile(context, console, dst);
        boolean ret = true;

        if (cSrc.equals(cDst) && !FileHelper.isSamePath(src, dst)) {
            // Is safe to use the same console
            MoveExecutable executable =
                    cSrc.getExecutableFactory().newCreator().createMoveExecutable(src, dst);
            writableExecute(context, executable, cSrc);
            ret = executable.getResult().booleanValue();
        } else {
            // We need to create a temporary file in the external filesystem to make it
            // available to virtual consoles

            // 1.- Move to a temporary file with the source console (destination
            // is a safe location)
            File tmp = FileHelper.createTempFilename(context, true);
            try {
                MoveExecutable moveExecutable =
                        cSrc.getExecutableFactory().newCreator().createMoveExecutable(
                                src, tmp.getAbsolutePath());
                writableExecute(context, moveExecutable, cSrc);
                if (!moveExecutable.getResult().booleanValue()) {
                    ret = false;
                }


                // 2.- Move the temporary file to the final filesystem with the destination console
                if (ret) {
                    moveExecutable =
                            cDst.getExecutableFactory().newCreator().createMoveExecutable(
                                    tmp.getAbsolutePath(), dst);
                    writableExecute(context, moveExecutable, cDst);
                    if (!moveExecutable.getResult().booleanValue()) {
                        ret = false;
                    }
                }

            } finally {
                FileHelper.deleteFileOrFolder(tmp);
            }
        }

        // Do media scan (don't scan the file if is virtual file)
        if (ret) {
            File parent = new File(dst).getParentFile();
            if ((parent != null && !VirtualMountPointConsole.isVirtualStorageResource(parent
                    .getAbsolutePath()))) {
                // Scan source
                MediaScannerConnection.scanFile(context, new String[] {
                        MediaHelper.normalizeMediaPath(src) }, null, null);

                // Recursive scan of the parent dir of the dest. This mitigates a VFAT
                // issue where a file named "foo." will silently be renamed as "foo".
                // This ensures that we report the correct filename to the media scanner
                // by re-reading the filename from the file system.
                recursiveScan(context, null, parent.getAbsolutePath(), 1);
            }
        }

        return ret;
    }

