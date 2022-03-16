        private void updateSummary(String key, boolean changing) {
            switch (key) {
                case Constants.KEY_PREF_HIDE_DESCRIPTION:
                    if (changing) {
                        Intent intent = new Intent(Constants.ACTION_FORCED_APPWIDGET_UPDATE);
                        intent.setPackage("org.thosp.yourlocalweather");
                        getActivity().sendBroadcast(intent);
                    }
                    break;
                case Constants.PREF_LANGUAGE:
                    entrySummary(key);
                    if (changing) {
                        String newLocale = PreferenceUtil.getLanguage(getActivity().getApplicationContext());
                        LanguageUtil.setLanguage(getActivity().getApplication(), newLocale);
                        updateLocationsLocale(newLocale);
                        WidgetUtils.updateWidgets(getActivity());
                        DialogFragment dialog = new SettingsAlertDialog().newInstance(R.string.update_locale_dialog_message);
                        dialog.show(getActivity().getFragmentManager(), "restartApp");
                    }
                    break;
                case Constants.PREF_THEME:
                    entrySummary(key);
                    if (changing) {
                        YourLocalWeather app = (YourLocalWeather) getActivity().getApplication();
                        app.reloadTheme();
                        app.applyTheme(getActivity());
                        restartApp(getActivity());
                    }
                    break;
                case Constants.KEY_PREF_WEATHER_ICON_SET:
                    entrySummary(key);
                    break;
                case Constants.KEY_PREF_OPEN_WEATHER_MAP_API_KEY:
                    findPreference(key).setSummary(ApiKeys.getOpenweathermapApiKeyForPreferences(getActivity()));
                    checkAndDeleteLocations();
                    break;
            }
        }

