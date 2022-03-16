        private void initWakeUpStrategy() {
            Preference wakeUpStrategy = findPreference(Constants.KEY_WAKE_UP_STRATEGY);
            wakeUpStrategy.setSummary(
                    getWakeUpStrategyLabel(
                            PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(Constants.KEY_WAKE_UP_STRATEGY, "nowakeup")
                    )
            );
            wakeUpStrategy.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference wakeUpStrategy, Object value) {
                    String wakeUpStrategyValue = (String) value;
                    wakeUpStrategy.setSummary(getString(getWakeUpStrategyLabel(wakeUpStrategyValue)));
                    return true;
                }
            });
        }

