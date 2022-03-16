    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (PREF_APP_THEME.equals(key)) {
            recreate();
        } else if (PREF_APP_LANGUAGE.equals(key)) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            String appLocaleCode = preferences.getString(PREF_APP_LANGUAGE, LANGUAGE_DEFAULT);

            String newAppLocaleCode;
            if (appLocaleCode.equals(LANGUAGE_DEFAULT)) {
                newAppLocaleCode = WorldWeatherApplication.systemLocaleCode;
            } else {
                newAppLocaleCode = appLocaleCode;
            }
            MiscMethods.updateLocale(newAppLocaleCode, getResources());

            recreate();
            resetActionBarTitle();
        } else if (PREF_PERSONAL_API_KEY.equals(key)) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            boolean shouldUsePersonalApiKey = preferences.getBoolean(PREF_PERSONAL_API_KEY, false);
            if (shouldUsePersonalApiKey) {
                showEnterPersonalApiKeyDialog();
            }
        }
    }

