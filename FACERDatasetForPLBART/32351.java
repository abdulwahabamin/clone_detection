    public void onLocationChanged(Location location, Address address) {
        appendLog(getBaseContext(), TAG, "onLocationChanged");
        sendMessageToWakeUpService(
                AppWakeUpManager.FALL_DOWN,
                AppWakeUpManager.SOURCE_LOCATION_UPDATE
        );
        lastLocationUpdateTime = System.currentTimeMillis();
        timerHandler.removeCallbacksAndMessages(null);
        removeUpdates(this);

        /*org.thosp.yourlocalweather.model.Location autoLocation = locationsDbHelper.getLocationByOrderId(0);
        float storedLocationAccuracy = autoLocation.getAccuracy();
        long storedLocationTime = autoLocation.getLastLocationUpdate();

        Calendar now = Calendar.getInstance();
        now.add(Calendar.MILLISECOND, -300000);

        // remove acccuracy checking to get fast responses
        if ((storedLocationTime > now.getTimeInMillis()) && (location != null) && (location.getAccuracy() > storedLocationAccuracy)) {
            appendLog(getBaseContext(), TAG, "stored location is recent and more accurate, stored location accuracy = " +
                    storedLocationAccuracy + ", location accuracy =" + ((location != null)?location.getAccuracy():"") +
                    ", stored location time = " + storedLocationTime + ", location time" + ((location != null)?location.getTime():""));
            locationDbHelper.updateLocationSource(currentLocation.getId(), locationSource);
            requestWeatherCheck();
            return;
        }*/

        if ((location == null) && gpsRequestLocation()) {
            updateLocationInProcess = false;
            stopRefreshRotation("onLocationChanged",3);
            return;
        }

        org.thosp.yourlocalweather.model.Location currentLocation;
        if (location == null) {
            LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());
            currentLocation = locationsDbHelper.getLocationByOrderId(0);
            locationsDbHelper.updateLocationSource(currentLocation.getId(), getString(R.string.location_weather_update_status_location_not_reachable));
        } else {
            currentLocation = processUpdateOfLocation(location, address);
        }
        appendLog(getBaseContext(), TAG, "send intent to get weather, updateSource ", updateSource);
        updateLocationInProcess = false;
        stopRefreshRotation("onLocationChanged",3);
        sendMessageToCurrentWeatherService(currentLocation, updateSource, AppWakeUpManager.SOURCE_CURRENT_WEATHER, forceUpdate, false);
        sendMessageToWeatherForecastService(currentLocation.getId(), updateSource, forceUpdate);
    }

