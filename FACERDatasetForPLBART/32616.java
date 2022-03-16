        private void updateSummary(String key, boolean changing) {
            entrySummary(key);
            switch (key) {
                case Constants.KEY_PREF_LOCATION_AUTO_UPDATE_PERIOD:
                case Constants.KEY_PREF_LOCATION_UPDATE_PERIOD:
                    if (changing) {
                        Intent intentToStartUpdate = new Intent("org.thosp.yourlocalweather.action.RESTART_ALARM_SERVICE");
                        intentToStartUpdate.setPackage("org.thosp.yourlocalweather");
                        getActivity().startService(intentToStartUpdate);
                    }
                    break;
                default:
                    break;
            }
        }

