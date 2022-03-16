    /**
     * {@inheritDoc}
     */
    @Override
    public SendSignalExecutable createSendSignalExecutable(int process, SIGNAL signal)
            throws CommandNotFoundException {
        try {
            return new SendSignalCommand(process, signal);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("SendSignalCommand", icdEx); //$NON-NLS-1$
        }
    }

