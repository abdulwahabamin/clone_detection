    /**
     * Method that saves a preference.
     *
     * @param pref The preference identifier
     * @param value The value of the preference
     * @param applied If the preference was applied
     * @throws InvalidClassException If the value of the preference is not of the
     * type of the preference
     */
    public static void savePreference(FileManagerSettings pref, Object value, boolean applied)
            throws InvalidClassException {
        Map<FileManagerSettings, Object> prefs =
                new HashMap<FileManagerSettings, Object>();
        prefs.put(pref, value);
        savePreferences(prefs, applied);
    }

