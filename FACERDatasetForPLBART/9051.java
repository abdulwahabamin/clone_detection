    /**
     * Constructor of <code>LinkCommand</code>.
     *
     * @param src The path of the source file
     * @param link The path of the link file
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public LinkCommand(String src, String link) throws InvalidCommandDefinitionException {
        super(ID, src, link);
        this.mLink = link;
    }

