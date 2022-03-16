    /**
     * Method that returns a console, and creates a new console if no
     * console is allocated or if the settings preferences has changed.
     *
     * @param context The current context
     * @param superuserMode If create with a superuser mode console (root access mode)
     * @param advancedMode If create with a advanced mode console (prompt or root access mode)
     * @return Console An allocated console
     * @throws FileNotFoundException If the initial directory not exists
     * @throws IOException If initial directory couldn't be checked
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     * @throws ConsoleAllocException If the console can't be allocated
     * @throws InsufficientPermissionsException If the console created is not a privileged console
     */
    //IMP! This must be invoked from the main activity creation
    public static Console createDefaultConsole(Context context,
            boolean superuserMode, boolean advancedMode)
            throws FileNotFoundException, IOException, InvalidCommandDefinitionException,
            ConsoleAllocException, InsufficientPermissionsException {

        synchronized (ConsoleBuilder.SYNC) {
            //Check if console settings has changed
            if (sHolder != null) {
                if (
                    (sHolder.getConsole() instanceof NonPriviledgeConsole && superuserMode)
                    || (sHolder.getConsole() instanceof PrivilegedConsole && !superuserMode)) {
                    //Deallocate actual console
                    sHolder.dispose();
                    sHolder = null;
                }
            }

            //Is there a console allocated
            if (sHolder == null) {
                sHolder = (superuserMode)
                        ? new ConsoleHolder(createAndCheckPrivilegedConsole(context))
                        : new ConsoleHolder(createNonPrivilegedConsole(context));
                if (superuserMode) {
                    // Change also the background console to privileged
                    FileManagerApplication.changeBackgroundConsoleToPriviligedConsole();
                }
            }
            return sHolder.getConsole();
        }
    }

