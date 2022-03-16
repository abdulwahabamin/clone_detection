    /**
     * Constructor of <code>CreateFileCommand</code>.
     *
     * @param fileName The name of the new file
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public CreateFileCommand(String fileName) throws InvalidCommandDefinitionException {
        super(ID, fileName);
        this.mFileName = fileName;
    }

