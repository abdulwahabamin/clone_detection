    /**
     * {@inheritDoc}
     */
    @Override
    public MoveExecutable createMoveExecutable(String src, String dst)
            throws CommandNotFoundException {
        try {
            return new MoveCommand(src, dst);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("MoveCommand", icdEx); //$NON-NLS-1$
        }
    }

