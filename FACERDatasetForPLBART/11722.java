    /**
     * @Constructor of <code>Command</code>
     *
     * @param id The resource identifier of the command
     * @param prepare Indicates if the argument must be prepared
     * @param args Arguments of the command (will be formatted with the arguments from
     * the command definition)
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    public Command(String id, boolean prepare, String... args)
            throws InvalidCommandDefinitionException {
        super();
        this.mId = id;

        //Convert and quote arguments
        this.mCmdArgs = new Object[args.length];
        int cc = args.length;
        for (int i = 0; i < cc; i++) {
            //Quote the arguments?
            if (prepare) {
                this.mCmdArgs[i] =
                        "\"" + ShellHelper.prepareArgument(args[i]) //$NON-NLS-1$
                        + "\""; //$NON-NLS-1$
            } else {
                this.mCmdArgs[i] = ShellHelper.prepareArgument(args[i]);
            }
        }

        //Load the command info
        getCommandInfo(FileManagerApplication.getInstance().getResources());

        // Get the current trace value
        reloadTrace();
    }

