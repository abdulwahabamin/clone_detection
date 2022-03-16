    /**
     * Method that saves the preferences passed as argument.
     *
     * @param prefs The preferences to be saved
     * @param applied If the preference was applied
     * @throws InvalidClassException If the value of a preference is not of the
     * type of the preference
     */
    public static void savePreferences(Map<FileManagerSettings, Object> prefs, boolean applied)
            throws InvalidClassException {
        savePreferences(prefs, true, applied);
    }

