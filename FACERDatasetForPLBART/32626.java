        private void entrySummary(String key, boolean changing) {
            if (Constants.KEY_PREF_IS_NOTIFICATION_ENABLED.equals(key)) {
                SwitchPreference switchPreference = (SwitchPreference) findPreference(key);
                if (switchPreference == null) {
                    return;
                }
                if (updateBySensor) {
                    switchPreference.setEnabled(false);
                } else {
                    switchPreference.setEnabled(true);
                }
            } else {
                SwitchPreference switchPreference = (SwitchPreference) findPreference(Constants.KEY_PREF_IS_NOTIFICATION_ENABLED);
                
                ListPreference preference = (ListPreference) findPreference(key);
                if (preference == null) {
                    return;
                }
                preference.setSummary(preference.getEntry());
                if (Constants.KEY_PREF_NOTIFICATION_PRESENCE.equals(key)) {
                    if (updateBySensor || !switchPreference.isChecked()) {
                        preference.setValue("permanent");
                        preference.setEnabled(false);
                    } else {
                        preference.setEnabled(true);
                    }
                    if ("permanent".equals(preference.getValue()) || "on_lock_screen".equals(preference.getValue())) {
                        SwitchPreference vibrate = (SwitchPreference) findPreference(Constants.KEY_PREF_VIBRATE);
                        vibrate.setEnabled(false);
                        vibrate.setChecked(false);
                    } else {
                        SwitchPreference vibrate = (SwitchPreference) findPreference(Constants.KEY_PREF_VIBRATE);
                        vibrate.setEnabled(true);
                    }
                    if (!"permanent".equals(preference.getValue())) {
                        NotificationManager notificationManager =
                                (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                        notificationManager.cancelAll();
                    }
                } else if (Constants.KEY_PREF_INTERVAL_NOTIFICATION.equals(key)) {
                    if (updateBySensor || !switchPreference.isChecked()) {
                        preference.setEnabled(false);
                    } else {
                        preference.setEnabled(true);
                    }
                } else {
                    preference.setEnabled(true);
                }
            }
            if (AppPreference.isNotificationEnabled(getActivity()) &&
                "permanent".equals(AppPreference.getNotificationPresence(getActivity()))) {
                NotificationUtils.weatherNotification(getActivity(),
                        NotificationUtils.getLocationForNotification(getActivity()).getId());
            }
        }

