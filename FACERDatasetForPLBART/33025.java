    protected void sendMessageToLocationUpdateService(Context context) {
        //startRefreshRotation("updateNetworkLocation", 3);
        if (checkIfLocationUpdateServiceIsNotBound(context)) {
            locationUpdateServiceActions.add(LocationUpdateService.LocationUpdateServiceActions.START_LOCATION_AND_WEATHER_UPDATE);
            return;
        } else {
            locationUpdateService.startLocationAndWeatherUpdate(null);
        }
    }

