                    @Override
                    public boolean onPreferenceChange(Preference preference, Object o) {
                        boolean isEnabled = (boolean) o;
                        AppPreference.setNotificationEnabled(getActivity(), isEnabled);
                        Intent intentToStartUpdate = new Intent("org.thosp.yourlocalweather.action.RESTART_NOTIFICATION_ALARM_SERVICE");
                        intentToStartUpdate.setPackage("org.thosp.yourlocalweather");
                        getActivity().startService(intentToStartUpdate);
                        updateSummaries(isEnabled);
                        NotificationManager notificationManager =
                            (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                        notificationManager.cancelAll();
                        return true;
                    }

