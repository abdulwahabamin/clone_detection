    /**
     * {@inheritDoc}
     */
    @Override
    public IdentityExecutable createIdentityExecutable() throws CommandNotFoundException {
        try {
            return new IdentityCommand();
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("IdentityCommand", icdEx); //$NON-NLS-1$
        }
    }

