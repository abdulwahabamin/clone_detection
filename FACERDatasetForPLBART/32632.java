        private void updateSummaries(boolean isNotificationEnabled) {
            for (String key : ENABLED_TO_UPDATE) {
                ListPreference preference = (ListPreference) findPreference(key);
                if (preference == null) {
                    return;
                }
                preference.setSummary(preference.getEntry());
                if (Constants.KEY_PREF_NOTIFICATION_PRESENCE.equals(key)) {
                    if (updateBySensor || !isNotificationEnabled) {
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
                    if (updateBySensor || !isNotificationEnabled) {
                        preference.setEnabled(false);
                    } else {
                        preference.setEnabled(true);
                    }
                } else {
                    preference.setEnabled(true);
                }
            }
        }

