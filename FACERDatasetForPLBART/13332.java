    /**
     * Method that prepares the system for re-execute the command.
     *
     * @param context The current context
     * @param relaunchable The {@link RelaunchableException} reference
     * @hide
     */
    static void prepare(final Context context, final RelaunchableException relaunchable) {
        //- This exception need change the console before re-execute
        if (relaunchable instanceof InsufficientPermissionsException) {
            ConsoleBuilder.changeToPrivilegedConsole(context);
        }
    }

