    private Updated performUpdateOfWeather(Calendar now,
                                        Location location,
                                        String updatePeriodStr,
                                        long updatePeriodMills,
                                        boolean notificationForLocation) {
        if (!notificationForLocation &&
                ("0".equals(updatePeriodStr) || (now.getTimeInMillis() < (location.getLastLocationUpdate() + updatePeriodMills)))) {
            return Updated.NOTHING;
        }
        if (notificationForLocation) {
            sendMessageToCurrentWeatherService(location, "NOTIFICATION", AppWakeUpManager.SOURCE_NOTIFICATION, true);
            AppPreference.setLastNotificationTimeInMs(getBaseContext(), now.getTimeInMillis());
            sendMessageToWeatherForecastService(location.getId());
            return Updated.BY_NOTIFICATION;
        } else {
            sendMessageToCurrentWeatherService(location, AppWakeUpManager.SOURCE_CURRENT_WEATHER, true);
            sendMessageToWeatherForecastService(location.getId());
            return Updated.REGULARLY;
        }
    }

