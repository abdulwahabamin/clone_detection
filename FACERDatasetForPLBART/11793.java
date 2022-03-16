    /**
     * Constructor of <code>ExecCommand</code>.
     *
     * @param cmd The absolute directory to compute
     * @param asyncResultListener The partial result listener
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public ExecCommand(
            String cmd, AsyncResultListener asyncResultListener)
            throws InvalidCommandDefinitionException {
        super(ID, asyncResultListener, new String[]{cmd});
    }

