    /**
     * Method that initializes the defaults preferences of the application.
     */
    public static void loadDefaults() {
        //Sets the default preferences if no value is set yet
        try {
            Map<FileManagerSettings, Object> defaultPrefs =
                    new HashMap<FileManagerSettings, Object>();
            FileManagerSettings[] values = FileManagerSettings.values();
            int cc = values.length;
            for (int i = 0; i < cc; i++) {
                defaultPrefs.put(values[i], values[i].getDefaultValue());
            }
            savePreferences(defaultPrefs, false, true);
        } catch (Exception ex) {
            Log.e(TAG, "Save default settings fails", ex); //$NON-NLS-1$
        }
    }

