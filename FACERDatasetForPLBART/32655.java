        @Override
        public void onResume() {
            super.onResume();
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
            Preference preference = findPreference(KEY_DEBUG_FILE);
            preference.setSummary(preferences.getString(KEY_DEBUG_FILE,""));
        }

