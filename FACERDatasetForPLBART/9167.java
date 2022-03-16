    /**
     * {@inheritDoc}
     */
    @Override
    public ChecksumExecutable createChecksumExecutable(
            String src, AsyncResultListener asyncResultListener)
            throws CommandNotFoundException, NoSuchFileOrDirectory,
            InsufficientPermissionsException {
        try {
            return new ChecksumCommand(src, asyncResultListener);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("ChecksumCommand", icdEx); //$NON-NLS-1$
        }
    }

