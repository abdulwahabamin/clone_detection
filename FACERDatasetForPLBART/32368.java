    private void updateNetworkLocationByNetwork(Location lastLocation,
                                                boolean byLastLocationOnly,
                                                Intent originalIntent,
                                                Integer attempts) {
        updateLocationInProcess = true;
        startRefreshRotation("updateNetworkLocationByNetwork", 3);
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());
        org.thosp.yourlocalweather.model.Location currentLocation = locationsDbHelper.getLocationByOrderId(0);
        if (resendRequestWhenNetworkNotAvailable(byLastLocationOnly, originalIntent, attempts)) {
            return;
        }

        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, -5);

        org.thosp.yourlocalweather.model.Location autoLocation = locationsDbHelper.getLocationByOrderId(0);
        long lastLocationUpdate = autoLocation.getLastLocationUpdate();
        long gpsLastLocationTime = getLocationTimeInMilis(lastLocation);
        appendLog(getBaseContext(), TAG,
                "Comparison of last location from GPS time = ",
                gpsLastLocationTime,
                ", and location last update time = ",
                lastLocationUpdate);
        Location inputLocation = null;
        if ((lastLocation != null) &&
                (gpsLastLocationTime > (System.currentTimeMillis() - GPS_MAX_LOCATION_AGE_IN_MS)) &&
                (gpsLastLocationTime > lastLocationUpdate)) {
            inputLocation = lastLocation;
            locationsDbHelper.updateLocationSource(currentLocation.getId(), getString(R.string.location_weather_update_status_location_from_gps));
        } else if (byLastLocationOnly) {
            updateLocationInProcess = false;
            sendMessageToWakeUpService(
                    AppWakeUpManager.FALL_DOWN,
                    AppWakeUpManager.SOURCE_LOCATION_UPDATE
            );
            stopRefreshRotation("updateNetworkLocationByNetwork:3", 3);
            return;
        }

        appendLog(getBaseContext(), TAG, "start START_LOCATION_UPDATE:locationsource is N or G");
        startLocationUpdate(inputLocation);
        timerHandler.postDelayed(timerRunnable, LOCATION_TIMEOUT_IN_MS);
    }

