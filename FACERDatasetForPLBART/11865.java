    /**
     * Constructor of <code>ProcessIdCommand</code>.<br/>
     * Use this to retrieve all PIDs running on a shell.
     *
     * @param pid The process identifier of the shell when the process is running
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public ProcessIdCommand(int pid) throws InvalidCommandDefinitionException {
        super(ID_SHELL_CMDS, new String[]{String.valueOf(pid)});
    }

