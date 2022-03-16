    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String appLanguage = preferences.getString(SettingsActivity.
                PREF_APP_LANGUAGE, LANGUAGE_DEFAULT);
        if (!appLanguage.equals(LANGUAGE_DEFAULT)) {
            MiscMethods.updateLocale(appLanguage, getResources());
            resetActionBarTitle();
        }
    }

