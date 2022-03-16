        @Override
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences()
                                 .registerOnSharedPreferenceChangeListener(this);

            for (String key : SUMMARIES_TO_UPDATE) {
                updateSummary(key, false);
            }
        }

