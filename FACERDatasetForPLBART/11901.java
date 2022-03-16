    /**
     * Constructor of <code>SendSignalCommand</code>.
     *
     * @param process The process which to send the signal
     * @param signal The signal to send
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public SendSignalCommand(int process, SIGNAL signal) throws InvalidCommandDefinitionException {
        super(ID_SIGNAL, String.valueOf(signal.getSignal()), String.valueOf(process));
    }

