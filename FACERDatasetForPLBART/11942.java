    /**
     * {@inheritDoc}
     */
    @Override
    public SendSignalExecutable createKillExecutable(int process)
            throws CommandNotFoundException {
        try {
            return new SendSignalCommand(process);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("SendSignalCommand", icdEx); //$NON-NLS-1$
        }
    }

