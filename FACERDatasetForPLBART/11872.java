    /**
     * @Constructor of <code>Program</code>
     *
     * @param id The resource identifier of the command
     * @param args Arguments of the command (will be formatted with the arguments from
     * the command definition)
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public Program(String id, String... args) throws InvalidCommandDefinitionException {
        super(id, args);
        this.mExitOnStdErrOutput = false;
    }

