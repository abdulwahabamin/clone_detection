    /**
     * Constructor of <code>WriteCommand</code>.
     *
     * @param file The file where to write the data
     * @param asyncResultListener The partial result listener
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public WriteCommand(
            String file, AsyncResultListener asyncResultListener)
            throws InvalidCommandDefinitionException {
        super(ID, asyncResultListener, file);
        this.mReady = false;
        this.mError = false;
    }

