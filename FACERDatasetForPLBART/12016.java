    /**
     * Method that creates a new privileged console. If the allocation of the
     * privileged console fails, the a non privileged console
     *
     * @param context The current context
     * @return Console The privileged console
     * @throws FileNotFoundException If the initial directory not exists
     * @throws IOException If initial directory couldn't be checked
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     * @throws ConsoleAllocException If the console can't be allocated
     * @throws InsufficientPermissionsException If the console created is not a privileged console
     * @see PrivilegedConsole
     */
    public static Console createPrivilegedConsole(Context context)
            throws FileNotFoundException, IOException, InvalidCommandDefinitionException,
            ConsoleAllocException, InsufficientPermissionsException {
        PrivilegedConsole console = new PrivilegedConsole();
        console.setBufferSize(context.getResources().getInteger(R.integer.buffer_size));
        console.alloc();
        if (console.getIdentity().getUser().getId() != ROOT_UID) {
            //The console is not a privileged console
            try {
                console.dealloc();
            } catch (Throwable ex) {
                /**NON BLOCK**/
            }
            throw new InsufficientPermissionsException(null);
        }
        return console;
    }

