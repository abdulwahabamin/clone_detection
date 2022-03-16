    @Override
    public void onCancelUpdatingPersonalApiKey() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putBoolean(PREF_PERSONAL_API_KEY, false).apply();

        PreferenceFragment preferenceFragment = (PreferenceFragment) getFragmentManager().
                findFragmentById(R.id.settings_content_frame_layout);
        CheckBoxPreference personalApiKeyCheckBoxPreference = (CheckBoxPreference)
                preferenceFragment.findPreference(PREF_PERSONAL_API_KEY);
        personalApiKeyCheckBoxPreference.setChecked(false);
    }

