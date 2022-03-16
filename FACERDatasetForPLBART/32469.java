    private void processScreenOnInBg(Context context) {
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());
        String updateAutoPeriodStr = AppPreference.getLocationAutoUpdatePeriod(getBaseContext());

        org.thosp.yourlocalweather.model.Location currentLocation = locationsDbHelper.getLocationByOrderId(0);

        if (!currentLocation.isEnabled() || !"0".equals(updateAutoPeriodStr)) {
            checkNotification(context);
            return;
        }
        CurrentWeatherDbHelper currentWeatherDbHelper = CurrentWeatherDbHelper.getInstance(getBaseContext());
        final WeatherForecastDbHelper weatherForecastDbHelper = WeatherForecastDbHelper.getInstance(context);
        CurrentWeatherDbHelper.WeatherRecord weatherRecord = currentWeatherDbHelper.getWeather(currentLocation.getId());
        WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord = weatherForecastDbHelper.getWeatherForecast(currentLocation.getId());
        long lastUpdateTimeInMilis = Utils.getLastUpdateTimeInMilis(weatherRecord, weatherForecastRecord, currentLocation);
        long now = System.currentTimeMillis();
        appendLog(context, TAG, "SCREEN_ON called, lastUpdate=",
                currentLocation.getLastLocationUpdate(),
                ", now=",
                now,
                ", lastUpdateTimeInMilis=",
                lastUpdateTimeInMilis);
        if ((now <= (lastUpdateTimeInMilis + UPDATE_WEATHER_ONLY_TIMEOUT)) || (now <= (currentLocation.getLastLocationUpdate() + REQUEST_UPDATE_WEATHER_ONLY_TIMEOUT))) {
            timerScreenOnHandler.postDelayed(timerScreenOnRunnable, UPDATE_WEATHER_ONLY_TIMEOUT - (now - lastUpdateTimeInMilis));
            checkNotification(context);
            return;
        }
        checkNotification(context);
        requestWeatherCheck(currentLocation.getId(), null, AppWakeUpManager.SOURCE_CURRENT_WEATHER, false);
        timerScreenOnHandler.postDelayed(timerScreenOnRunnable, UPDATE_WEATHER_ONLY_TIMEOUT);
    }

