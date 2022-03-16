        @Override
        public void onPause() {
            super.onPause();
            unbindReconciliationDbService();
            getPreferenceScreen().getSharedPreferences()
                                 .unregisterOnSharedPreferenceChangeListener(this);
        }

