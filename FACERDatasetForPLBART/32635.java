        private void entrySummary(String key) {
            if (!Constants.KEY_PREF_LOCATION_GPS_ENABLED.equals(key)) {
                ListPreference preference = (ListPreference) findPreference(key);
                if (preference == null) {
                    return;
                }
                preference.setSummary(preference.getEntry());
            }
        }

