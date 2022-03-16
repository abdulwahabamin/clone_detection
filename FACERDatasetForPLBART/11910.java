    /**
     * {@inheritDoc}
     */
    @Override
    public void checkExitCode(int exitCode)
            throws InsufficientPermissionsException, CommandNotFoundException, ExecutionException {
        //Command not found
        if (exitCode == 127) {
            Log.w(TAG, String.format(
                        "CommandNotFound: %s %s", //$NON-NLS-1$
                        getCommand(),
                        getArguments()));
            throw new CommandNotFoundException(getId());
        }
        //No exit code
        if (exitCode == 255) {
            throw new ExecutionException(getId());
        }
    }

