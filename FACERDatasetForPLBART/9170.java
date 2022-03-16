    /**
     * Constructor of <code>SuperuserShell</code>.
     *
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public SuperuserShell() throws InvalidCommandDefinitionException {
        super(ID, ShellHelper.getProgramCmdLine(new BashShell()));
    }

