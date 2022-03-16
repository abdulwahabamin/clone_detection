        private void entrySummary(String key) {
            ListPreference preference = (ListPreference) findPreference(key);
            if (preference == null) {
                return;
            }
            preference.setSummary(preference.getEntry());
            if (Constants.KEY_PREF_LOCATION_AUTO_UPDATE_PERIOD.equals(key)) {
                if ("0".equals(preference.getValue())) {
                    AppPreference.setNotificationEnabled(getActivity(), true);
                    AppPreference.setNotificationPresence(getActivity(), "permanent");
                } else {
                    AppPreference.setNotificationEnabled(getActivity(), false);
                    AppPreference.setNotificationPresence(getActivity(), "when_updated");
                    NotificationManager notificationManager =
                        (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                        notificationManager.cancelAll();
                }
            }
        }

