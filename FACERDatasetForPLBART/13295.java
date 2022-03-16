    /**
     * Method that ensure the console retrieve the default console if a console
     * is not passed.
     *
     * @param context The current context (needed if console == null)
     * @param console The console passed
     * @param src The source file to check
     * @return Console The console passed if not is null. Otherwise, the default console
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     * @throws ConsoleAllocException If the console can't be allocated
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     * @throws IOException If initial directory couldn't be checked
     * @throws FileNotFoundException If the initial directory not exists
     */
    public static Console ensureConsoleForFile(Context context, Console console, String src)
            throws FileNotFoundException, IOException, InvalidCommandDefinitionException,
            ConsoleAllocException, InsufficientPermissionsException {

        // Check if the path belongs to a virtual mount point
        Console c = VirtualMountPointConsole.getVirtualConsoleForPath(src);
        if (c != null) {
            return c;
        }

        // Recover a real console
        c = console;
        if (c == null) {
            c = ConsoleBuilder.getConsole(context);
        }
        return c;
    }

