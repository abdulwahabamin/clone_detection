    /**
     * {@inheritDoc}
     */
    @Override
    public void checkExitCode(int exitCode)
            throws InsufficientPermissionsException, CommandNotFoundException, ExecutionException {
        if (exitCode != 0 && exitCode != 1) {  //Permission denied
            throw new ExecutionException("exitcode != 0 && != 1"); //$NON-NLS-1$
        }
    }

