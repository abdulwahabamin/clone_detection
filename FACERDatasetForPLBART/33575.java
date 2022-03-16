    /**
     * Sets the user preferred (or default, if no preference was set) app theme.
     */
    private void setAppTheme() {
        Resources res = getResources();
        String appThemeValue = PreferenceManager.getDefaultSharedPreferences(this).getString(
                SettingsActivity.PREF_APP_THEME,
                res.getString(R.string.pref_app_theme_default));

        int themeResourceId = getThemeResourceId(appThemeValue);
        setTheme(themeResourceId);
    }

