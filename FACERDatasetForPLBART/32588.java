        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_general);

            EditTextPreference openWeatherMapApiKey =
                    (EditTextPreference) findPreference(Constants.KEY_PREF_OPEN_WEATHER_MAP_API_KEY);
            openWeatherMapApiKey.setSummary(ApiKeys.getOpenweathermapApiKeyForPreferences(getActivity()));
        }

