        private void initLogFileChooser() {

            Preference logToFileCheckbox = findPreference(KEY_DEBUG_TO_FILE);
            logToFileCheckbox.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(final Preference preference, Object value) {
                    if (!checkWriteToSdcardPermission()) {
                        return false;
                    }
                    boolean logToFile = (Boolean) value;
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                    preferences.edit().putBoolean(KEY_DEBUG_TO_FILE, logToFile).apply();
                    LogToFile.logToFileEnabled = logToFile;
                    return true;
                }
            });

            Preference buttonFileLog = findPreference(KEY_DEBUG_FILE);
            buttonFileLog.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(final Preference preference) {
                    new ChooserDialog().with(getActivity())
                            .withFilter(true, false)
                            .withStartFile("/mnt")
                            .withChosenListener(new ChooserDialog.Result() {
                                @Override
                                public void onChoosePath(String path, File pathFile) {
                                    String logFileName = path + "/log-yourlocalweather.txt";
                                    LogToFile.logFilePathname = logFileName;
                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                                    preferences.edit().putString(KEY_DEBUG_FILE, logFileName).apply();
                                    preference.setSummary(preferences.getString(KEY_DEBUG_FILE,""));
                                }
                            })
                            .build()
                            .show();
                    return true;
                }
            });
        }

