    /**
     * Constructor of <code>ParentDirCommand</code>.
     *
     * @param src The file system object to read
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public ParentDirCommand(String src) throws InvalidCommandDefinitionException {
        super(ID, src);
    }

