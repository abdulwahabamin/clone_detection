    /**
     * Constructor of <code>SendSignalCommand</code>. This method sends a kill (terminate)
     *
     * @param process The process which to send the signal
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public SendSignalCommand(int process) throws InvalidCommandDefinitionException {
        super(ID_TERMINATE, String.valueOf(process));
    }

