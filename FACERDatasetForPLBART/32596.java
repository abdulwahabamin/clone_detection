        private void setDefaultValues() {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
            if (!preferences.contains(Constants.PREF_LANGUAGE)) {
                preferences.edit().putString(Constants.PREF_LANGUAGE, Resources.getSystem().getConfiguration().locale.getLanguage()).apply();
                entrySummary(Constants.PREF_LANGUAGE);
            }
        }

