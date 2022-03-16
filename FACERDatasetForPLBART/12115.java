    /**
     * Constructor of <code>NonPriviledgeConsole</code>.
     *
     * @throws FileNotFoundException If the default initial directory not exists
     * @throws IOException If initial directory couldn't be checked
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public NonPriviledgeConsole()
            throws FileNotFoundException, IOException, InvalidCommandDefinitionException {
        super(new BashShell());
    }

