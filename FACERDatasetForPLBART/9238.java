    /**
     * Method that creates a new privileged console. If the allocation of the
     * privileged console fails, the a non privileged console
     *
     * @param context The current context
     * @param silent Indicates that no message have to be displayed
     * @return Console The privileged console
     * @throws FileNotFoundException If the initial directory not exists
     * @throws IOException If initial directory couldn't be checked
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     * @throws ConsoleAllocException If the console can't be allocated
     * @throws InsufficientPermissionsException If the console created is not a privileged console
     * @see PrivilegedConsole
     */
    public static Console createAndCheckPrivilegedConsole(
            Context context, boolean silent)
            throws FileNotFoundException, IOException, InvalidCommandDefinitionException,
            ConsoleAllocException, InsufficientPermissionsException {
        try {
            // Create the privileged console
            return createPrivilegedConsole(context);

        } catch (ConsoleAllocException caEx) {
            //Show a message with the problem?
            Log.w(TAG, context.getString(R.string.msgs_privileged_console_alloc_failed), caEx);
            if (!silent) {
                try {
                    DialogHelper.showToast(context,
                            R.string.msgs_privileged_console_alloc_failed, Toast.LENGTH_LONG);
                } catch (Exception ex) {
                    Log.e(TAG, "can't show toast", ex);  //$NON-NLS-1$
                }
            }

            boolean advancedMode =
                    FileManagerApplication.getAccessMode().compareTo(AccessMode.SAFE) != 0;
            if (advancedMode) {
                //Save settings
                try {
                    Preferences.savePreference(
                            FileManagerSettings.SETTINGS_ACCESS_MODE, AccessMode.PROMPT, true);
                } catch (Exception ex) {
                    Log.e(TAG,
                            String.format("Failed to save %s property",  //$NON-NLS-1$
                            FileManagerSettings.SETTINGS_ACCESS_MODE.getId()), ex);
                }

                //Create the non-privileged console
                return createNonPrivilegedConsole(context);
            }

            // Rethrow the exception
            throw caEx;
        }
    }

