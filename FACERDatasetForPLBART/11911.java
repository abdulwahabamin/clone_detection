    /**
     * Method that checks if the standard errors has exceptions.
     *
     * @param program The program
     * @param exitCode Program exit code
     * @param err Standard Error buffer
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws CommandNotFoundException If the command was not found
     * @throws ExecutionException If the another exception is detected in the standard error
     * @throws ReadOnlyFilesystemException If the operation writes in a read-only filesystem
     * @hide
     */
    @SuppressWarnings("static-method")
    public void checkStdErr(Program program, int exitCode, String err)
            throws InsufficientPermissionsException, NoSuchFileOrDirectory,
            CommandNotFoundException, ExecutionException, ReadOnlyFilesystemException {
        //Check problems in the standard error
        if (exitCode != 0 && err.indexOf("No such file or directory") != -1) { //$NON-NLS-1$
            throw new NoSuchFileOrDirectory();
        }
        //Normally usage code is generated for invalid commands, but let's assume
        //that the invalid command is generated for and error caused for non
        //existing directory
        if (err.indexOf("Usage:") != -1) { //$NON-NLS-1$
            throw new NoSuchFileOrDirectory();
        }
        if (err.indexOf("Permission denied") != -1) { //$NON-NLS-1$
            if (program instanceof SyncResultExecutable) {
                throw new InsufficientPermissionsException((SyncResultExecutable)program);
            }
            throw new InsufficientPermissionsException();
        }
        if (exitCode != 0 && err.indexOf("Operation not permitted") != -1) { //$NON-NLS-1$
            if (program instanceof SyncResultExecutable) {
                throw new InsufficientPermissionsException((SyncResultExecutable)program);
            }
            throw new InsufficientPermissionsException();
        }
        if (err.indexOf("Read-only file system") != -1) { //$NON-NLS-1$
            if (program instanceof WritableExecutable) {
                // This error could be caused by dst or src. No matter which. Use dst.
                throw new ReadOnlyFilesystemException(
                        ((WritableExecutable)program).getDstWritableMountPoint());
            }
            throw new ExecutionException("Read-only file system");  //$NON-NLS-1$
        }
    }

