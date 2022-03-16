    /**
     * {@inheritDoc}
     */
    @Override
    public FolderUsageExecutable createFolderUsageExecutable(
            String directory, AsyncResultListener asyncResultListener)
            throws CommandNotFoundException {
        try {
            return new FolderUsageCommand(directory, asyncResultListener);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("FolderUsageCommand", icdEx); //$NON-NLS-1$
        }
    }

