    /**
     * Obtains the key required to complete any Open Weather Map query.
     *
     * @return OWM API key with the required prefix
     */
    private String getApiKey() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean shouldUsePersonalApiKey = preferences.getBoolean(PREF_PERSONAL_API_KEY, false);
        String key = shouldUsePersonalApiKey ? SharedPrefsHelper.getPersonalApiKeyFromSharedPrefs(
                context) : DEVELOPER_API_KEY;
        return OPEN_WEATHER_MAP_API_KEY_PREFIX + key;
    }

