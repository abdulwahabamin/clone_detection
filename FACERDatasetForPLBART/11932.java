    /**
     * {@inheritDoc}
     */
    @Override
    public MountPointInfoExecutable createMountPointInfoExecutable()
            throws CommandNotFoundException {
        try {
            return new MountPointInfoCommand();
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("MountPointInfoCommand", icdEx); //$NON-NLS-1$
        }
    }

