        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_general);

            bindPreferenceSummaryToValue(findPreference("API_key_value"));

            final String defaultKeyString = getActivity().getString(R.string.settings__API_key_default);

            final Preference resetKeyPref = findPreference("API_key_reset");
            resetKeyPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
            {
                @Override
                public boolean onPreferenceClick(final Preference preference)
                {
                    new AlertDialog.Builder(getActivity())
                        .setTitle(R.string.settings_confirm_title_API_key_reset)
                        .setMessage(R.string.settings_confirm_content_API_key_reset)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditTextPreference APIKeyValuePref = ((EditTextPreference)findPreference("API_key_value"));
                                APIKeyValuePref.setText(defaultKeyString);
                                APIKeyValuePref.setSummary(defaultKeyString);
                                OwmApiData.resetAPI_KEY();
                            }
                        }).setNegativeButton(android.R.string.cancel, null).create().show();

                    return false;
                }
            });

            final EditTextPreference valueKeyPref = (EditTextPreference) findPreference("API_key_value");
            valueKeyPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newVal) {

                    String stringValue = newVal.toString();

                    if(preference instanceof EditTextPreference) {
                        if(preference.getKey().equals("API_key_value")) {
                            if(stringValue.equals(defaultKeyString)) {
                                OwmApiData.resetAPI_KEY();
                            } else {
                                OwmApiData.setAPI_KEY(stringValue);
                            }
                        }
                    }

                    preference.setSummary(stringValue);

                    return true;
                }
            });

        }

