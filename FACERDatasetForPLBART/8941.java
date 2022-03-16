    /**
     * @Constructor of <code>Command</code>
     *
     * @param id The resource identifier of the command
     * @param args Arguments of the command (will be formatted with the arguments from
     * the command definition)
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public Command(String id, String... args) throws InvalidCommandDefinitionException {
        this(id, true, args);
    }

