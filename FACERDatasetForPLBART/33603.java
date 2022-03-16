    /**
     * Saves users personal API key.
     *
     * @param key OWM developer key
     */
    public static void putPersonalApiKeyIntoSharedPrefs(Context context, String key) {
        getEditor(context).putString(PERSONAL_API_KEY, key).apply();
    }

