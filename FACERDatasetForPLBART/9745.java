    /**
     * Method that saves the preferences passed as argument.
     *
     * @param prefs The preferences to be saved
     * @param noSaveIfExists No saves if the preference if has a value
     * @param applied If the preference was applied
     * @throws InvalidClassException If the value of a preference is not of the
     * type of the preference
     */
    @SuppressWarnings("unchecked")
    private static void savePreferences(
            Map<FileManagerSettings, Object> prefs, boolean noSaveIfExists, boolean applied)
            throws InvalidClassException {
        //Get the preferences editor
        SharedPreferences sp = getSharedPreferences();
        Editor editor = sp.edit();

        //Save all settings
        Iterator<FileManagerSettings> it = prefs.keySet().iterator();
        while (it.hasNext()) {
            FileManagerSettings pref = it.next();
            if (!noSaveIfExists && sp.contains(pref.getId())) {
                //The preference already has a value
                continue;
            }

            //Known and valid types
            Object value = prefs.get(pref);
            if (value instanceof Boolean && pref.getDefaultValue() instanceof Boolean) {
                editor.putBoolean(pref.getId(), ((Boolean)value).booleanValue());
            } else if (value instanceof String && pref.getDefaultValue() instanceof String) {
                editor.putString(pref.getId(), (String)value);
            } else if (value instanceof Integer && pref.getDefaultValue() instanceof Integer) {
                editor.putInt(pref.getId(), (Integer)value);
            } else if (value instanceof Set && pref.getDefaultValue() instanceof Set) {
                editor.putStringSet(pref.getId(), (Set<String>)value);
            } else if (value instanceof ObjectIdentifier
                    && pref.getDefaultValue() instanceof ObjectIdentifier) {
                editor.putInt(pref.getId(), ((ObjectIdentifier)value).getId());
            } else if (value instanceof ObjectStringIdentifier
                    && pref.getDefaultValue() instanceof ObjectStringIdentifier) {
                editor.putString(pref.getId(), ((ObjectStringIdentifier)value).getId());
            } else {
                //The object is not of the appropriate type
                String msg = String.format(
                                    "%s: %s",  //$NON-NLS-1$
                                    pref.getId(),
                                    value.getClass().getName());
                Log.e(TAG, String.format(
                                "Configuration error. InvalidClassException: %s",  //$NON-NLS-1$
                                msg));
                throw new InvalidClassException(msg);
            }

        }

        //Commit settings
        editor.commit();

        //Now its time to communicate the configuration change
        if (CONFIGURATION_LISTENERS != null && CONFIGURATION_LISTENERS.size() > 0) {
            it = prefs.keySet().iterator();
            while (it.hasNext()) {
                FileManagerSettings pref = it.next();
                Object value = prefs.get(pref);
                int cc = CONFIGURATION_LISTENERS.size();
                for (int i = 0; i < cc; i++) {
                    CONFIGURATION_LISTENERS.get(i).onConfigurationChanged(pref, value, applied);
                }
            }
        }
    }

