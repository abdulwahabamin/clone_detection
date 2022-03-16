    /**
     * Constructor of <code>PrivilegedConsole</code>.
     *
     * @throws FileNotFoundException If the default initial directory not exists
     * @throws IOException If initial directory couldn't be checked
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public PrivilegedConsole()
            throws FileNotFoundException, IOException, InvalidCommandDefinitionException {
        super(new SuperuserShell());
    }

