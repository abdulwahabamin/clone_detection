    /**
     * Method that reload the status of trace setting
     */
    public final void reloadTrace() {
        this.mTrace = Preferences.getSharedPreferences().getBoolean(
                FileManagerSettings.SETTINGS_SHOW_TRACES.getId(),
                ((Boolean)FileManagerSettings.SETTINGS_SHOW_TRACES.getDefaultValue()).booleanValue());
    }

