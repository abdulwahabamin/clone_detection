    /**
     * Constructor of <code>EchoCommand</code>.
     *
     * @param msg The message to echo. This message can have one or multiple variables
     * and text. xe: "This is $VAR_1 the value of $VAR2" or simple "$PATH"
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public EchoCommand(String msg) throws InvalidCommandDefinitionException {
        super(ID, msg);
    }

