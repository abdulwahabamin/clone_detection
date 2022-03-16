    /**
     * {@inheritDoc}
     */
    @Override
    public DiskUsageExecutable createDiskUsageExecutable(String dir)
            throws CommandNotFoundException {
        try {
            return new DiskUsageCommand(dir);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("DiskUsageCommand", icdEx); //$NON-NLS-1$
        }
    }

