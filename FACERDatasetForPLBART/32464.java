        @Override
        public void run() {
            if (!WidgetUtils.isInteractive(getBaseContext())) {
                return;
            }
            CurrentWeatherDbHelper currentWeatherDbHelper = CurrentWeatherDbHelper.getInstance(getBaseContext());
            final WeatherForecastDbHelper weatherForecastDbHelper = WeatherForecastDbHelper.getInstance(getBaseContext());
            LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());
            org.thosp.yourlocalweather.model.Location currentLocation = locationsDbHelper.getLocationByOrderId(0);
            CurrentWeatherDbHelper.WeatherRecord weatherRecord = currentWeatherDbHelper.getWeather(currentLocation.getId());

            appendLog(getBaseContext(), TAG, "timerScreenOnRunnable:weatherRecord=", weatherRecord);
            if (weatherRecord == null) {
                requestWeatherCheck(currentLocation.getId(), null, AppWakeUpManager.SOURCE_CURRENT_WEATHER, false);
                timerScreenOnHandler.postDelayed(timerScreenOnRunnable, UPDATE_WEATHER_ONLY_TIMEOUT);
                return;
            }
            WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord = weatherForecastDbHelper.getWeatherForecast(currentLocation.getId());
            long lastUpdateTimeInMilis = Utils.getLastUpdateTimeInMilis(weatherRecord, weatherForecastRecord, currentLocation);
            long now = System.currentTimeMillis();

            appendLog(getBaseContext(), TAG, "screen timer called, lastUpdate=",
                    currentLocation.getLastLocationUpdate(),
                    ", now=",
                    now,
                    ", lastUpdateTimeInMilis=",
                    lastUpdateTimeInMilis);

            if ((now <= (lastUpdateTimeInMilis + UPDATE_WEATHER_ONLY_TIMEOUT)) || (now <= (currentLocation.getLastLocationUpdate() + REQUEST_UPDATE_WEATHER_ONLY_TIMEOUT))) {
                timerScreenOnHandler.postDelayed(timerScreenOnRunnable, REQUEST_UPDATE_WEATHER_ONLY_TIMEOUT);
                return;
            }
            appendLog(getBaseContext(), TAG, "timerScreenOnRunnable:requestWeatherCheck");
            requestWeatherCheck(currentLocation.getId(), null, AppWakeUpManager.SOURCE_CURRENT_WEATHER, false);
            timerScreenOnHandler.postDelayed(timerScreenOnRunnable, UPDATE_WEATHER_ONLY_TIMEOUT);
        }

