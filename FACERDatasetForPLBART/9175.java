    /**
     * @Constructor of <code>SyncResultProgram</code>
     *
     * @param id The resource identifier of the command
     * @param prepare Indicates if the argument must be prepared
     * @param args Arguments of the command (will be formatted with the arguments from
     * the command definition)
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public SyncResultProgram(String id, boolean prepare, String... args)
            throws InvalidCommandDefinitionException {
        super(id, prepare, args);
    }

