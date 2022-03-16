        private void initLogFileLasting() {
            Preference logFileLasting = findPreference(KEY_DEBUG_FILE_LASTING_HOURS);
            logFileLasting.setSummary(
                    getLogFileLastingLabel(Integer.parseInt(
                            PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(KEY_DEBUG_FILE_LASTING_HOURS, "24"))
                    )
            );
            logFileLasting.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference logFileLasting, Object value) {
                    String logFileLastingHoursTxt = (String) value;
                    Integer logFileLastingHours = Integer.valueOf(logFileLastingHoursTxt);
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                    preferences.edit().putString(KEY_DEBUG_FILE_LASTING_HOURS, logFileLastingHoursTxt).apply();
                    logFileLasting.setSummary(getString(getLogFileLastingLabel(logFileLastingHours)));
                    LogToFile.logFileHoursOfLasting = logFileLastingHours;
                    return true;
                }
            });
        }

