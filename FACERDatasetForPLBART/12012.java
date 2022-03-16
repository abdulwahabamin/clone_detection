    /**
     * Method that returns a console, and creates a new console if no
     * console is allocated or if the settings preferences has changed.
     *
     * @param context The current context
     * @return Console An allocated console
     * @throws FileNotFoundException If the initial directory not exists
     * @throws IOException If initial directory couldn't be checked
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     * @throws ConsoleAllocException If the console can't be allocated
     * @throws InsufficientPermissionsException If the console created is not a privileged console
     */
    //IMP! This must be invoked from the main activity creation
    public static Console createDefaultConsole(Context context)
            throws FileNotFoundException, IOException, InvalidCommandDefinitionException,
            ConsoleAllocException, InsufficientPermissionsException {
        //Gets superuser mode settings
        boolean superuserMode =
                FileManagerApplication.getAccessMode().compareTo(AccessMode.ROOT) == 0;
        boolean advancedMode =
                FileManagerApplication.getAccessMode().compareTo(AccessMode.SAFE) != 0;
        boolean restrictedMode =
                AndroidHelper.hasSupportForMultipleUsers(context) && !AndroidHelper.isUserOwner();
        if (restrictedMode) {
            // Is a secondary user. Restrict access to the whole system
            try {
                Preferences.savePreference(
                        FileManagerSettings.SETTINGS_ACCESS_MODE, AccessMode.SAFE, true);
            } catch (Throwable ex) {
                Log.w(TAG, "can't save console preference", ex); //$NON-NLS-1$
            }
            superuserMode = false;
        }
        else if (superuserMode && !advancedMode) {
            try {
                Preferences.savePreference(
                        FileManagerSettings.SETTINGS_ACCESS_MODE, AccessMode.PROMPT, true);
            } catch (Throwable ex) {
                Log.w(TAG, "can't save console preference", ex); //$NON-NLS-1$
            }
            superuserMode = false;
        }
        return createDefaultConsole(context, superuserMode, advancedMode);
    }

