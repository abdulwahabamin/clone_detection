    /**
     * Constructor of <code>ChecksumCommand</code>.
     *
     * @param src The source file
     * @param asyncResultListener The partial result listener
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public ChecksumCommand(String src, AsyncResultListener asyncResultListener)
            throws InvalidCommandDefinitionException {
        super(ID, asyncResultListener, src);
        this.mChecksums = new String[]{null, null};
        this.mName = new File(src).getName();
    }

