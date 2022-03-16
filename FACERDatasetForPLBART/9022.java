    /**
     * Constructor of <code>FindCommand</code>.
     *
     * @param directory The absolute path of the directory where do the search
     * @param query The terms to be searched
     * @param asyncResultListener The partial result listener
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public FindCommand(
            String directory, Query query, AsyncResultListener asyncResultListener)
            throws InvalidCommandDefinitionException {
        super(ID, asyncResultListener, createArgs(FileHelper.addTrailingSlash(directory), query));
        this.mDirectory = new File(directory);
    }

