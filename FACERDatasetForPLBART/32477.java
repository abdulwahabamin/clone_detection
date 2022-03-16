    public void checkAndUpdateWeather() {
        CurrentWeatherDbHelper currentWeatherDbHelper = CurrentWeatherDbHelper.getInstance(this);
        final WeatherForecastDbHelper weatherForecastDbHelper = WeatherForecastDbHelper.getInstance(this);
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(this);

        List<Location> locations = locationsDbHelper.getAllRows();

        for (Location location: locations) {

            if (!location.isEnabled()) {
                continue;
            }

            CurrentWeatherDbHelper.WeatherRecord weatherRecord = currentWeatherDbHelper.getWeather(location.getId());

            appendLog(this, TAG, "weatherRecord=", weatherRecord);
            if (weatherRecord == null) {
                requestWeatherCheck(location.getId(), null, AppWakeUpManager.SOURCE_CURRENT_WEATHER, false);
                continue;
            }
            WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord = weatherForecastDbHelper.getWeatherForecast(location.getId());
            long lastUpdateTimeInMilis = Utils.getLastUpdateTimeInMilis(weatherRecord, weatherForecastRecord, location);
            long now = System.currentTimeMillis();

            long updatePeriodForLocation;
            if (location.getOrderId() == 0) {
                String updateAutoPeriodStr = AppPreference.getLocationAutoUpdatePeriod(this);
                updatePeriodForLocation = Utils.intervalMillisForAlarm(updateAutoPeriodStr);
            } else {
                String updatePeriodStr = AppPreference.getLocationUpdatePeriod(this);
                updatePeriodForLocation = Utils.intervalMillisForAlarm(updatePeriodStr);
            }

            appendLog(this, TAG, "network state changed, location.orderId=",
                    location.getOrderId(),
                    ", updatePeriodForLocation=",
                    updatePeriodForLocation,
                    ", now=",
                    now,
                    ", lastUpdateTimeInMilis=",
                    lastUpdateTimeInMilis);

            if (now <= (lastUpdateTimeInMilis + updatePeriodForLocation)) {
                appendLog(this, TAG, "network state changed, location is not going to update, because last update is recent enough. location.orderId=",
                        location.getOrderId());
                continue;
            }
            appendLog(this, TAG, "requestWeatherCheck");
            requestWeatherCheck(location.getId(), null, AppWakeUpManager.SOURCE_CURRENT_WEATHER, false);
        }
    }

