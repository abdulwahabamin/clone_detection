    /**
     * {@inheritDoc}
     */
    @Override
    public ResolveLinkExecutable createResolveLinkExecutable(String fso)
            throws CommandNotFoundException {
        try {
            return new ResolveLinkCommand(fso);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("ResolveLinkCommand", icdEx); //$NON-NLS-1$
        }
    }

