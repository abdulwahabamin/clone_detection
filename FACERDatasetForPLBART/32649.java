        @Override
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences()
                                 .registerOnSharedPreferenceChangeListener(this);
            setSummary(Constants.KEY_PREF_WIDGET_THEME);
            setDetailedSummary(Constants.KEY_PREF_UPDATE_DETAIL);
        }

