    /**
     * {@inheritDoc}
     */
    @Override
    public void checkExitCode(int exitCode)
            throws InsufficientPermissionsException, CommandNotFoundException, ExecutionException {
        // 123: stat failed ... Function not implemented (for broken symlinks)
        if (exitCode != 0 && exitCode != 1 && exitCode != 123) {
            throw new ExecutionException("exitcode != 0 && != 1 && != 123"); //$NON-NLS-1$
        }
    }

