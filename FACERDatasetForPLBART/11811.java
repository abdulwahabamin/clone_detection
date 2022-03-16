    /**
     * Constructor of <code>FolderUsageCommand</code>.
     *
     * @param directory The absolute directory to compute
     * @param asyncResultListener The partial result listener
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public FolderUsageCommand(
            String directory, AsyncResultListener asyncResultListener)
            throws InvalidCommandDefinitionException {
        super(ID, asyncResultListener, new String[]{directory});
        this.mFolderUsage = new FolderUsage(directory);
        this.mDirectory = directory;
    }

