    private Updated performUpdateOfAutolocation(Calendar now,
                                             Location location,
                                             String updateAutoPeriodStr,
                                             long updateAutoPeriodMills,
                                             boolean notificationForLocation) {
        long lastSensorServicesCheckTimeInMs = AppPreference.getLastSensorServicesCheckTimeInMs(getBaseContext());
        if ("0".equals(updateAutoPeriodStr)) {
            if ((now.getTimeInMillis() >= (lastSensorServicesCheckTimeInMs + AppAlarmService.START_SENSORS_CHECK_PERIOD))) {
                sensorLocationUpdateService.startSensorBasedUpdates(0);
                AppPreference.setLastSensorServicesCheckTimeInMs(getBaseContext(), now.getTimeInMillis());
            }
            if (notificationForLocation)  {
                locationUpdateService.startLocationAndWeatherUpdate("NOTIFICATION");
                AppPreference.setLastNotificationTimeInMs(getBaseContext(), now.getTimeInMillis());
                return Updated.BY_NOTIFICATION;
            }
        } else if ("OFF".equals(updateAutoPeriodStr)) {
            sensorLocationUpdateService.stopSensorBasedUpdates();
            if (notificationForLocation)  {
                locationUpdateService.startLocationAndWeatherUpdate("NOTIFICATION");
                AppPreference.setLastNotificationTimeInMs(getBaseContext(), now.getTimeInMillis());
                return Updated.BY_NOTIFICATION;
            }
        } else if (notificationForLocation || (now.getTimeInMillis() >= (location.getLastLocationUpdate() + updateAutoPeriodMills))) {
            sensorLocationUpdateService.stopSensorBasedUpdates();
            if (notificationForLocation) {
                locationUpdateService.startLocationAndWeatherUpdate("NOTIFICATION");
                AppPreference.setLastNotificationTimeInMs(getBaseContext(), now.getTimeInMillis());
                return Updated.BY_NOTIFICATION;
            } else {
                locationUpdateService.startLocationAndWeatherUpdate(false);
                return Updated.REGULARLY;
            }
        }
        return Updated.NOTHING;
    }

