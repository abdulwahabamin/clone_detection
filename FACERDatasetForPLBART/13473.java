    /**
     * Method that returns the command line of a program command to be used as part as the
     * arguments of the shell command.
     *
     * @param command The program command to parse
     * @return String The  command line of a program command
     */
    public static String getProgramCmdLine(Command command) {
        //The command line must be like "<cmd> <args>" with double quotes, replacing
        //all double quotes <args> by \"
        String args = command.getArguments();
        if (args == null) {
            args = ""; //$NON-NLS-1$
        }
        StringBuilder subcmd = new StringBuilder();
        subcmd.append(command.getCommand())
              .append(" ") //$NON-NLS-1$
              .append(args);

        //Prepare and build command string
        return ShellHelper.prepareArgument(subcmd.toString());
    }

