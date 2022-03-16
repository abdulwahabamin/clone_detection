    /**
     * Method that creates a new non privileged console.
     *
     * @param context The current context
     * @return Console The non privileged console
     * @throws FileNotFoundException If the initial directory not exists
     * @throws IOException If initial directory couldn't be checked
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     * @throws ConsoleAllocException If the console can't be allocated
     * @see NonPriviledgeConsole
     */
    public static Console createNonPrivilegedConsole(Context context)
            throws FileNotFoundException, IOException,
            InvalidCommandDefinitionException, ConsoleAllocException {

        int bufferSize = context.getResources().getInteger(R.integer.buffer_size);

        // Is rooted? Then create a shell console
        if (FileManagerApplication.hasShellCommands()) {
            NonPriviledgeConsole console = new NonPriviledgeConsole();
            console.setBufferSize(bufferSize);
            console.alloc();
            return console;
        }

        // No rooted. Then create a java console
        JavaConsole console = new JavaConsole(context, bufferSize);
        console.alloc();
        return console;
    }

