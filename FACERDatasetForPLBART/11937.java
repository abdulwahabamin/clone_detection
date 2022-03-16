    /**
     * {@inheritDoc}
     */
    @Override
    public ProcessIdExecutable createProcessIdExecutable(int pid, String processName)
            throws CommandNotFoundException {
        try {
            return new ProcessIdCommand(pid, processName);
        } catch (InvalidCommandDefinitionException icdEx) {
            throw new CommandNotFoundException("ProcessIdCommand", icdEx); //$NON-NLS-1$
        }
    }

