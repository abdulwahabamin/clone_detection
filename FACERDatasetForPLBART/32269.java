    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        int ret = super.onStartCommand(intent, flags, startId);

        if (intent == null) {
            return ret;
        }
        appendLog(getBaseContext(), TAG, "onStartCommand:intent.getAction():", intent.getAction());
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());
        if ("org.thosp.yourlocalweather.action.START_ALARM_SERVICE".equals(intent.getAction())) {
            setAlarm();
        } else if ("org.thosp.yourlocalweather.action.RESTART_ALARM_SERVICE".equals(intent.getAction())) {
            alarmStarted = false;
            setAlarm();
        } else if ("org.thosp.yourlocalweather.action.RESTART_NOTIFICATION_ALARM_SERVICE".equals(intent.getAction())) {
            scheduleNextNotificationAlarm();
        } else if ("org.thosp.yourlocalweather.action.START_LOCATION_WEATHER_ALARM_AUTO".equals(intent.getAction())) {
            String updateAutoPeriodStr = AppPreference.getLocationAutoUpdatePeriod(getBaseContext());
            if (!"0".equals(updateAutoPeriodStr) && !"OFF".equals(updateAutoPeriodStr)) {
                long updateAutoPeriodMills = Utils.intervalMillisForAlarm(updateAutoPeriodStr);
                scheduleNextRegularAlarm(getBaseContext(), true, updateAutoPeriodMills);
            }

            long locationId = locationsDbHelper.getLocationByOrderId(0).getId();
            Intent intentToStartUpdate = new Intent("android.intent.action.START_LOCATION_AND_WEATHER_UPDATE");
            intentToStartUpdate.setPackage("org.thosp.yourlocalweather");
            intentToStartUpdate.putExtra("locationId", locationId);
            startBackgroundService(intentToStartUpdate);
        } else if ("org.thosp.yourlocalweather.action.START_LOCATION_WEATHER_ALARM_REGULAR".equals(intent.getAction())) {
            String updatePeriodStr = AppPreference.getLocationUpdatePeriod(getBaseContext());
            long updatePeriodMills = Utils.intervalMillisForAlarm(updatePeriodStr);
            if (!"0".equals(updatePeriodStr) && (locationsDbHelper.getAllRows().size() > 1)) {
                scheduleNextRegularAlarm(getBaseContext(), false, updatePeriodMills);
            }
            List<Location> locations = locationsDbHelper.getAllRows();
            for (Location location: locations) {
                if (location.getOrderId() == 0) {
                    continue;
                } else {
                    sendMessageToCurrentWeatherService(location, AppWakeUpManager.SOURCE_CURRENT_WEATHER, true);
                    scheduleNextLocationWeatherForecastUpdate(location.getId());
                }
            }
        }
        return ret;
    }

