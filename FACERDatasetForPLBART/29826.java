        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_main);

            // gallery EditText change listener
            bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_refresh_interval)));

            // notification preference change listener
            bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_units)));

            findPreference(Constants.PREF_ENABLE_NOTIFS).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object o) {
                    NotificationService.enqueueWork(getActivity() , new Intent(getActivity() , WeatherActivity.class));
                    return true;
                }
            });

            findPreference(Constants.PREF_DISPLAY_LANGUAGE).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object o) {
                    new MaterialDialog.Builder(getActivity())
                            .title(getString(R.string.restart_app))
                            .content(getString(R.string.restart_app_content))
                            .show();
                    return true;
                }
            });

            findPreference(Constants.PREF_OWM_KEY).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    new MaterialDialog.Builder(getActivity())
                            .title(getString(R.string.pref_owm_key_title))
                            .content(getString(R.string.pref_owm_key_summary))
                            .neutralText(getString(R.string.reset))
                            .onNeutral(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    new Prefs(getActivity()).setWeatherKey(Constants.OWM_APP_ID);
                                }
                            })
                            .negativeText(getString(android.R.string.cancel))
                            .onNegative(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog , @NonNull DialogAction which) {
                                    dialog.dismiss();
                                }
                            })
                            .input(null, new Prefs(getActivity()).getWeatherKey(), new MaterialDialog.InputCallback() {
                                @Override
                                public void onInput(@NonNull MaterialDialog dialog, @NonNull CharSequence input) {
                                    if (input.length() == 0)
                                        Snack.make(getActivity().findViewById(android.R.id.content) , "Please enter a valid key" , Snack.LENGTH_SHORT);
                                    else {
                                        try {
                                            if (new CheckConnection(getActivity()).isNetworkAvailable() && !new Prefs(getActivity()).getWeatherKey().equals(input.toString())) {
                                                new Prefs(getActivity()).setWeatherKey(input.toString());
                                                Info info = new FetchWeather(getActivity()).execute(new Prefs(getActivity()).getCity()).get();
                                                if (info.day.getCod() != 200) {
                                                    new MaterialDialog.Builder(getActivity())
                                                            .title("Unable to Fetch Weather Key")
                                                            .content("There may be some problem in the weather key entered. Reseting to the default one..")
                                                            .positiveText(android.R.string.ok);
                                                    new Prefs(getActivity()).setWeatherKey(Constants.OWM_APP_ID);
                                                }
                                            }
                                            else {
                                                new MaterialDialog.Builder(getActivity())
                                                        .title(getString(R.string.no_internet_title))
                                                        .cancelable(false)
                                                        .content(getString(R.string.no_internet_content))
                                                        .positiveText(getString(R.string.no_internet_mobile_data))
                                                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                                                            @Override
                                                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                                                Intent intent = new Intent();
                                                                intent.setComponent(new ComponentName("com.android.settings","com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                startActivityForResult(intent , 0);
                                                            }
                                                        })
                                                        .negativeText(getString(R.string.no_internet_wifi))
                                                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                                                            @Override
                                                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                                                startActivityForResult(new Intent(Settings.ACTION_WIFI_SETTINGS) , 0);
                                                            }
                                                        })
                                                        .show();
                                            }
                                        }
                                        catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }).show();
                    return true;
                }
            });

            findPreference(Constants.PREF_DELETE_CITIES).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    new MaterialDialog.Builder(getActivity())
                            .title(getString(R.string.pref_delete_cities_title))
                            .content(getString(R.string.pref_delete_cities_summary))
                            .positiveText(getString(android.R.string.ok))
                            .items(new DBHelper(getActivity()).getCities())
                            .itemsCallbackMultiChoice(null, new MaterialDialog.ListCallbackMultiChoice() {
                                @Override
                                public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                                    for (CharSequence city : text) {
                                        changed = 1;
                                        new DBHelper(getActivity()).deleteCity(city.toString());
                                    }
                                    return true;
                                }
                            })
                            .show();
                    return true;
                }
            });

            findPreference(Constants.PREF_DISPLAY_LANGUAGE).setOnPreferenceChangeListener(this);
        }

