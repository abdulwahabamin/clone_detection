        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            String key = preference.getKey();
            if (DEBUG) {
                Log.d(TAG,
                    String.format("New value for %s: %s",  //$NON-NLS-1$
                            key,
                            String.valueOf(newValue)));
            }

            // Saved search terms
            if (preference.getKey().compareTo(
                    FileManagerSettings.SETTINGS_SAVE_SEARCH_TERMS.getId()) == 0) {
                if (!((Boolean)newValue).booleanValue()) {
                    // Remove search terms if saved search terms
                    // is not active by the user
                    clearRecentSearchTerms();
                }

            // Sort search result mode
            } else if (FileManagerSettings.SETTINGS_SORT_SEARCH_RESULTS_MODE.
                    getId().compareTo(key) == 0) {
                int value = Integer.valueOf((String)newValue).intValue();
                String[] summary = getResources().getStringArray(
                        R.array.sort_search_results_mode_labels);
                preference.setSummary(summary[value]);
            }

            // Notify the change (only if fragment is loaded. Default values are loaded
            // while not in loaded mode)
            if (SearchPreferenceFragment.this.mLoaded) {
                Intent intent = new Intent(FileManagerSettings.INTENT_SETTING_CHANGED);
                intent.putExtra(
                        FileManagerSettings.EXTRA_SETTING_CHANGED_KEY, preference.getKey());
                getActivity().sendBroadcast(intent);
            }

            return true;
        }

