        private void updateSummary(String key, boolean changing) {
            switch (key) {
                case Constants.KEY_PREF_TEMPERATURE:
                    entrySummary(key);
                    if (changing) {
                        getActivity().sendBroadcast(new Intent(Constants.ACTION_FORCED_APPWIDGET_UPDATE));
                    }
                    break;
                case Constants.KEY_PREF_HIDE_DESCRIPTION:
                    if (changing) {
                        getActivity().sendBroadcast(new Intent(Constants.ACTION_FORCED_APPWIDGET_UPDATE));
                    }
                    break;
                case Constants.KEY_PREF_INTERVAL_NOTIFICATION:
                    entrySummary(key);
                    if (changing) {
                        Preference pref = findPreference(key);
                        NotificationService.setNotificationServiceAlarm(getActivity(), pref.isEnabled());
                    }
                    break;
                case Constants.PREF_LANGUAGE:
                    entrySummary(key);
                    if (changing) {
                        DialogFragment dialog = new SettingsAlertDialog().newInstance(R.string.restart_dialog_message);
                        dialog.show(getActivity().getFragmentManager(), "restartApp");
                    }
                    break;
                case Constants.PREF_THEME:
                    entrySummary(key);
                    if (changing) {
                        GoodWeatherApp app = (GoodWeatherApp) getActivity().getApplication();
                        app.reloadTheme();
                        app.applyTheme(getActivity());
                        restartApp(getActivity());
                    }
                    break;
            }
        }

