        @Override
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences()
                    .registerOnSharedPreferenceChangeListener(this);
            String updateAutoPeriodStr = AppPreference.getLocationAutoUpdatePeriod(getActivity());
            updateBySensor = "0".equals(updateAutoPeriodStr);
            updateSummaries();
        }

