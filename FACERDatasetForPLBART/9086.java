    /**
     * Constructor of <code>ProcessIdCommand</code>.<br/>
     * Use this to retrieve the PID of a command running on a shell.
     *
     * @param pid The process identifier of the shell when the process is running
     * @param processName The process name
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public ProcessIdCommand(int pid, String processName) throws InvalidCommandDefinitionException {
        super(ID_CMD, new String[]{processName, String.valueOf(pid)});
    }

