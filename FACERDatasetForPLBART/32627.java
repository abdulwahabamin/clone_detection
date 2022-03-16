        private void updateSummary(String key, boolean changing) {
            switch (key) {
                case Constants.KEY_PREF_IS_NOTIFICATION_ENABLED:
                case Constants.KEY_PREF_INTERVAL_NOTIFICATION:
                    entrySummary(key, changing);
                    if (changing) {
                        Intent intentToStartUpdate = new Intent("org.thosp.yourlocalweather.action.RESTART_ALARM_SERVICE");
                        intentToStartUpdate.setPackage("org.thosp.yourlocalweather");
                        getActivity().startService(intentToStartUpdate);
                    }
                    break;
                case Constants.KEY_PREF_NOTIFICATION_PRESENCE:
                case Constants.KEY_PREF_NOTIFICATION_STATUS_ICON:
                case Constants.KEY_PREF_NOTIFICATION_VISUAL_STYLE:
                    entrySummary(key, changing);
            }
        }

