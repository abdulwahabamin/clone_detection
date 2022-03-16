    /**
     * {@inheritDoc}
     */
    @Override
    public void checkStdErr(Program program, int exitCode, String err)
            throws InsufficientPermissionsException, NoSuchFileOrDirectory,
            CommandNotFoundException, ExecutionException, ReadOnlyFilesystemException {
        if (exitCode != 0) {
            if (err.startsWith(": not found")) { //$NON-NLS-1$
                throw new CommandNotFoundException(err);
            }
            super.checkStdErr(program, exitCode, err);
        }
    }

