    /**
     * {@inheritDoc}
     */
    @Override
    public MountExecutable createMountExecutable(MountPoint mp, boolean rw)
            throws CommandNotFoundException {
        try {
            return new MountCommand(mp, rw);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("MountCommand", icdEx); //$NON-NLS-1$
        }
    }

