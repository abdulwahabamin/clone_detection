    /**
     * Constructor of <code>DeleteDirCommand</code>.
     *
     * @param fileName The name of the directory to be deleted
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public DeleteDirCommand(String fileName) throws InvalidCommandDefinitionException {
        super(ID, fileName);
        this.mFileName = fileName;
    }

