    /**
     * Constructor of <code>ChangePermissionsCommand</code>.
     *
     * @param fileName The name of the file or directory to be moved
     * @param newPermissions The new permissions to apply to the object
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public ChangePermissionsCommand(
            String fileName, Permissions newPermissions) throws InvalidCommandDefinitionException {
        super(ID, newPermissions.toOctalString(), fileName);
        this.mFileName = fileName;
    }

