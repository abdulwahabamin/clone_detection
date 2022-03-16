    /**
     * {@inheritDoc}
     */
    @Override
    public ChangePermissionsExecutable createChangePermissionsExecutable(
            String fso, Permissions newPermissions) throws CommandNotFoundException {
        try {
            return new ChangePermissionsCommand(fso, newPermissions);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("ChangePermissionsCommand", icdEx); //$NON-NLS-1$
        }
    }

