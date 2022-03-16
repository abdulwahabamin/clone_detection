    /**
     * This method must returns the name of the full qualified command path.<br />
     * <br />
     * This method always must returns a full qualified path, and not an
     * abbreviation to the command to avoid security problems.<br />
     * In the same way, a command not must contains any type of arguments.
     * Arguments must be passed through method {@link #getArguments()}
     *
     * @return String The full qualified command path
     * @see #getArguments()
     */
    public String getCommand() {
        return this.mCmd;
    }

