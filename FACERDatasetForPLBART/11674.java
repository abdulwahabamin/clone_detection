    /**
     * @Constructor of <code>AsyncResultProgram</code>.
     *
     * @param id The resource identifier of the command
     * @param asyncResultListener The partial result listener
     * @param args Arguments of the command (will be formatted with the arguments from
     * the command definition)
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public AsyncResultProgram(
            String id, AsyncResultListener asyncResultListener, String... args)
            throws InvalidCommandDefinitionException {
        this(id, true, asyncResultListener, args);
    }

