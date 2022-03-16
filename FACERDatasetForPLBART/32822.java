    public static Notification getWeatherNotification(Context context, Long locationId) {
        if (locationId == null) {
            appendLog(context, TAG, "showNotification - locationId is null");
            return null;
        }
        final CurrentWeatherDbHelper currentWeatherDbHelper = CurrentWeatherDbHelper.getInstance(context);
        final LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(context);
        Location currentLocation = locationsDbHelper.getLocationById(locationId);
        if (currentLocation == null) {
            appendLog(context, TAG, "showNotification - current location is null");
            return null;
        }
        CurrentWeatherDbHelper.WeatherRecord weatherRecord =
                currentWeatherDbHelper.getWeather(currentLocation.getId());

        if (weatherRecord == null) {
            appendLog(context, TAG, "showNotification - current weather record is null");
            return null;
        }
        return getNotification(context, currentLocation, weatherRecord);
    }

