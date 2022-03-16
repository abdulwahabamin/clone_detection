    /**
     * {@inheritDoc}
     */
    @Override
    public ChangeOwnerExecutable createChangeOwnerExecutable(
            String fso, User newUser, Group newGroup) throws CommandNotFoundException {
        try {
            return new ChangeOwnerCommand(fso, newUser, newGroup);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("ChangeOwnerCommand", icdEx); //$NON-NLS-1$
        }
    }

