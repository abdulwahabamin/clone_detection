    /**
     * Constructor of <code>QuickFolderSearchCommand</code>.
     *
     * @param regexp The expression to search
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public QuickFolderSearchCommand(String regexp) throws InvalidCommandDefinitionException {
        super(ID, regexp);
        this.mQuickFolders = new ArrayList<String>();
    }

