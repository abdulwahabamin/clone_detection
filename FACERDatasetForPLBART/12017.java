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
    public static Console createAndCheckPrivilegedConsole(Context context)
            throws FileNotFoundException, IOException, InvalidCommandDefinitionException,
            ConsoleAllocException, InsufficientPermissionsException {
        return createAndCheckPrivilegedConsole(context, true);
    }

