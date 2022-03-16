        private void initLocationCache() {

            Preference locationCacheEnabled = findPreference(Constants.APP_SETTINGS_LOCATION_CACHE_ENABLED);
            locationCacheEnabled.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {

                @Override
                public boolean onPreferenceChange(Preference preference, Object value) {
                    boolean enabled = (Boolean) value;
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                    preferences.edit().putBoolean(Constants.APP_SETTINGS_LOCATION_CACHE_ENABLED, enabled).apply();
                    return true;
                }
            });

            Preference locationLasting = findPreference(Constants.APP_SETTINGS_LOCATION_CACHE_LASTING_HOURS);
            locationLasting.setSummary(
                    getLocationLastingLabel(Integer.parseInt(
                            PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(Constants.APP_SETTINGS_LOCATION_CACHE_LASTING_HOURS, "720"))
                    )
            );
            locationLasting.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference locationLasting, Object value) {
                    String locationRowLastingHoursTxt = (String) value;
                    Integer locationRowLastingHours = Integer.valueOf(locationRowLastingHoursTxt);
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                    preferences.edit().putString(Constants.APP_SETTINGS_LOCATION_CACHE_LASTING_HOURS, locationRowLastingHoursTxt).apply();
                    locationLasting.setSummary(getString(getLocationLastingLabel(locationRowLastingHours)));
                    return true;
                }
            });


            Preference button = findPreference("clear_cache_button");
            button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    ReverseGeocodingCacheDbHelper mDbHelper = ReverseGeocodingCacheDbHelper.getInstance(preference.getContext());
                    SQLiteDatabase db = mDbHelper.getWritableDatabase();
                    mDbHelper.onUpgrade(db, 0, 0);
                    return true;
                }
            });

            Preference dbInfo = findPreference("db_info");
            dbInfo.setSummary(getDataFromCacheDB());
        }

