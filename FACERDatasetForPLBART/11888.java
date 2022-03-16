    /**
     * Constructor of <code>ExecCommand</code>.
     *
     * @param file The file to read
     * @param asyncResultListener The partial result listener
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public ReadCommand(
            String file, AsyncResultListener asyncResultListener)
            throws InvalidCommandDefinitionException {
        super(ID, asyncResultListener, new String[]{file});
    }

