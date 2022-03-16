    private static void savePreferences(Map<WeatherSettings, Object> prefs, boolean noSaveIfExists) throws InvalidClassException {

        SharedPreferences sp = getSharedPreferences();
        SharedPreferences.Editor editor = sp.edit();

        for (WeatherSettings pref : prefs.keySet()) {

            Object value = prefs.get(pref);

            if (noSaveIfExists && sp.contains(pref.getId())) {
                continue;
            }

            if (value instanceof Boolean && pref.getDefaultValue() instanceof Boolean) {
                editor.putBoolean(pref.getId(), (Boolean) value);
            } else if (value instanceof String && pref.getDefaultValue() instanceof String) {
                editor.putString(pref.getId(), (String) value);
            } else if (value instanceof Set && pref.getDefaultValue() instanceof Set) {
                editor.putStringSet(pref.getId(), (Set<String>) value);
            } else if (value instanceof Integer && pref.getDefaultValue() instanceof Integer) {
                editor.putInt(pref.getId(), (Integer) value);
            } else if (value instanceof Float && pref.getDefaultValue() instanceof Float) {
                editor.putFloat(pref.getId(), (Float) value);
            } else if (value instanceof Long && pref.getDefaultValue() instanceof Long) {
                editor.putLong(pref.getId(), (Long) value);
            } else {
                //The object is not of the appropriate type
                String msg = String.format("%s: %s", pref.getId(), value.getClass().getName());
                Log.e(TAG, String.format("Configuration error. InvalidClassException: %s", msg));
                throw new InvalidClassException(msg);
            }
        }

        editor.apply();

        if (CONFIGURATION_LISTENERS != null && CONFIGURATION_LISTENERS.size() > 0) {
            for (WeatherSettings pref : prefs.keySet()) {
                Object value = prefs.get(pref);
                for (ConfigurationListener listener : CONFIGURATION_LISTENERS) {
                    listener.onConfigurationChanged(pref, value);
                }
            }
        }
    }

