    /**
     * {@inheritDoc}
     */
    @Override
    public GroupsExecutable createGroupsExecutable() throws CommandNotFoundException {
        try {
            return new GroupsCommand();
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("GroupsCommand", icdEx); //$NON-NLS-1$
        }
    }

