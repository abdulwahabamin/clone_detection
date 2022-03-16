    /**
     * {@inheritDoc}
     */
    @Override
    public EchoExecutable createEchoExecutable(String msg) throws CommandNotFoundException {
        try {
            return new EchoCommand(msg);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("EchoCommand", icdEx); //$NON-NLS-1$
        }
    }

