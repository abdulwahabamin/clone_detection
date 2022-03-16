    /**
     * Method that returns the access mode of the application
     *
     * @return boolean If the access mode of the application
     */
    public static AccessMode getAccessMode() {
        if (!sHasShellCommands) {
            return AccessMode.SAFE;
        }
        String defaultValue =
                ((ObjectStringIdentifier)FileManagerSettings.
                            SETTINGS_ACCESS_MODE.getDefaultValue()).getId();
        String id = FileManagerSettings.SETTINGS_ACCESS_MODE.getId();
        AccessMode mode =
                AccessMode.fromId(Preferences.getSharedPreferences().getString(id, defaultValue));
        return mode;
    }

