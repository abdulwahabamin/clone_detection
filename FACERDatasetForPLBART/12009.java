    /**
     * Method that returns a console. If {@linkplain "createIfNotExists"} is specified
     * a new console will be created
     *
     * @param context The current context
     * @param createIfNotExists Indicates that the console should be create if not exists
     * @return Console An allocated console
     * @throws FileNotFoundException If the initial directory not exists
     * @throws IOException If initial directory couldn't be checked
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     * @throws ConsoleAllocException If the console can't be allocated
     * @throws InsufficientPermissionsException If the console created is not a privileged console
     */
    public static Console getConsole(Context context, boolean createIfNotExists)
            throws FileNotFoundException, IOException, InvalidCommandDefinitionException,
            ConsoleAllocException, InsufficientPermissionsException {

        //Check if has a console. Otherwise create a new console
        if (sHolder == null || sHolder.getConsole() == null) {
            if (!createIfNotExists) {
                return null;
            }
            createDefaultConsole(context);
        }
        return sHolder.getConsole();
    }

