        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_general);
            setHasOptionsMenu(true);
            bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_unit_key)));
            bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_sync_key)));
            bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_selected_lang_key)));
        }

