    private void saveWeatherAndSendResult(Context context, Weather weather) {
        final LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(context);
        Long locationId = locationsDbHelper.getLocationIdByCoordinates(weather.getLat(), weather.getLon());
        if (locationId == null) {
            appendLog(context,
                    TAG,
                    "Weather not saved because there is no location with coordinates:",
                            weather.getLat(),
                            ", ",
                            weather.getLon());
            sendResult(ACTION_WEATHER_UPDATE_FAIL, context);
            return;
        }
        appendLog(getBaseContext(), TAG, "saveWeatherAndSendResult:locationId:", locationId);
        Location currentLocation = locationsDbHelper.getLocationById(locationId);
        String locationSource = currentLocation.getLocationSource();
        appendLog(getBaseContext(), TAG, "saveWeatherAndSendResult:locationSource by location:", locationSource);
        if ((currentLocation.getOrderId() > 0) ||
            (locationSource == null) ||
                getString(R.string.location_weather_update_status_update_started).equals(locationSource) ||
                getString(R.string.location_weather_update_status_location_not_reachable).equals(locationSource)) {
            locationSource = getString(R.string.location_weather_update_status_weather_only);
        }
        appendLog(context,
                TAG,
                "Location source is:", locationSource);

        long now = System.currentTimeMillis();
        final CurrentWeatherDbHelper currentWeatherDbHelper = CurrentWeatherDbHelper.getInstance(context);
        currentWeatherDbHelper.saveWeather(locationId, now, weather);

        sendMessageToWeatherByVoiceService(currentLocation, weather, now);
        locationsDbHelper.updateLastUpdatedAndLocationSource(locationId, now, locationSource);
        sendResult(ACTION_WEATHER_UPDATE_OK, context, locationId);
    }

