    /**
     * Constructor of <code>DeleteFileCommand</code>.
     *
     * @param fileName The name of the file to be deleted
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public DeleteFileCommand(String fileName) throws InvalidCommandDefinitionException {
        super(ID, fileName);
        this.mFileName = fileName;
    }

