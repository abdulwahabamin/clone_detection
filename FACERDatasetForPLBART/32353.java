    private void checkDistanceAndRemoveForecastIfTheNewLocationIsFarAway(Location location, org.thosp.yourlocalweather.model.Location currentLocation) {
        double distanceBetweenLocationsInKm = distance(location.getLatitude(), location.getLongitude(), currentLocation.getLatitude(), currentLocation.getLongitude());
        appendLog(getBaseContext(), TAG, "Distance between old and new location (in Km)=", distanceBetweenLocationsInKm);
        if (distanceBetweenLocationsInKm > 10) {
            appendLog(getBaseContext(), TAG, "Distance between old and new location is more than 10 Km, removing current weather and forecast");
            WeatherForecastDbHelper weatherForecastDbHelper = WeatherForecastDbHelper.getInstance(getBaseContext());
            weatherForecastDbHelper.deleteRecordByLocation(currentLocation);
            CurrentWeatherDbHelper currentWeatherDbHelper = CurrentWeatherDbHelper.getInstance(getBaseContext());
            currentWeatherDbHelper.deleteRecordByLocation(currentLocation);
        }
    }

