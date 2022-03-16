    /**
     * Constructor of <code>ChangeOwnerCommand</code>.
     *
     * @param fileName The name of the file or directory to be moved
     * @param newUser The new user owner of the object
     * @param newGroup The new group owner of the object
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public ChangeOwnerCommand(
            String fileName, User newUser, Group newGroup)
            throws InvalidCommandDefinitionException {
        super(ID, String.valueOf(newUser.getId()), String.valueOf(newGroup.getName()), fileName);
        this.mFileName = fileName;
    }

