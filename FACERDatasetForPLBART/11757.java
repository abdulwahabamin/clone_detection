    /**
     * Constructor of <code>CreateDirCommand</code>.
     *
     * @param fileName The name of the new directory
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public CreateDirCommand(String fileName) throws InvalidCommandDefinitionException {
        super(ID, fileName);
        this.mFileName = fileName;
    }

