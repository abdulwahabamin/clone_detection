    /**
     * {@inheritDoc}
     */
    @Override
    public void checkExitCode(int exitCode)
            throws InsufficientPermissionsException, CommandNotFoundException, ExecutionException {
        // We have not privileges to read the file
        if (exitCode == 1) {
            throw new InsufficientPermissionsException();
        }

        //Ignore exit code 143 (cancelled)
        //Ignore exit code 137 (kill -9)
        if (exitCode != 0 && exitCode != 143 && exitCode != 137) {
            throw new ExecutionException(
                        "exitcode != 0 &&  && exitCode != 1 && != 143 && != 137"); //$NON-NLS-1$
        }
    }

