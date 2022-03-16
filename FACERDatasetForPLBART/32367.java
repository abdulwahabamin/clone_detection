    public boolean updateNetworkLocation(boolean bylastLocationOnly,
                                      Intent originalIntent,
                                      Integer attempts,
                                      boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
        updateLocationInProcess = true;
        startRefreshRotation("updateNetworkLocation", 3);
        boolean permissionsGranted = PermissionUtil.checkPermissionsAndSettings(this);
        appendLog(getBaseContext(), TAG, "updateNetworkLocation:", permissionsGranted);
        if (!permissionsGranted) {
            updateLocationInProcess = false;
            stopRefreshRotation("updateNetworkLocation", 3);
            return false;
        }
        boolean isNetworkEnabled = locationManager.getAllProviders().contains(LocationManager.NETWORK_PROVIDER)
                && locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        boolean isGPSEnabled = AppPreference.isGpsEnabledByPreferences(getBaseContext()) &&
                locationManager.getAllProviders().contains(LocationManager.GPS_PROVIDER)
                && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        String geocoder = AppPreference.getLocationGeocoderSource(getBaseContext());
        boolean networkNotEnabled = !isNetworkEnabled && "location_geocoder_system".equals(geocoder);

        appendLog(getBaseContext(), TAG,
                "updateNetworkLocation:networkNotEnabled=",
                networkNotEnabled,
                ", isGPSEnabled=",
                isGPSEnabled,
                ", bylastLocationOnly=",
                bylastLocationOnly,
                ", isNetworkEnabled=",
                isNetworkEnabled);
        sendMessageToWakeUpService(
                AppWakeUpManager.WAKE_UP,
                AppWakeUpManager.SOURCE_LOCATION_UPDATE
        );
        if (networkNotEnabled && isGPSEnabled && !bylastLocationOnly) {
            appendLog(getBaseContext(), TAG, "updateNetworkLocation:request GPS and start rotation");
            if (gpsRequestLocation()) {
                return true;
            }
        }

        try {
            ConnectionDetector connectionDetector = new ConnectionDetector(getApplicationContext());
            LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getApplicationContext());
            org.thosp.yourlocalweather.model.Location currentLocationForSensorEvent = locationsDbHelper.getLocationByOrderId(0);
            if (!connectionDetector.isNetworkAvailableAndConnected()) {
                appendLog(this, TAG, "Network is not available");
                if (!timerNetworkAvailabilityHandler.hasMessages(0) && !updateLocationInProcess) {
                    timerNetworkAvailabilityHandler.postDelayed(timerNetworkAvailabilityRunnable, NETWORK_AVAILABILITY_TIMEOUT_IN_MS);
                }
                return false;
            }
            timerNetworkAvailabilityHandler.removeCallbacksAndMessages(null);
            /*locationsDbHelper.updateLocationSource(currentLocationForSensorEvent.getId(),
                    getString(R.string.location_weather_update_status_update_started));*/
        } catch (Exception e) {
            appendLog(this, TAG, "Exception occured during database update", e);
            updateLocationInProcess = false;
            stopRefreshRotation("updateNetworkLocation", 3);
            sendMessageToWakeUpService(
                    AppWakeUpManager.FALL_DOWN,
                    AppWakeUpManager.SOURCE_LOCATION_UPDATE
            );
            return false;
        }

        appendLog(getBaseContext(), TAG, "updateNetworkLocation:wakeup and start rotation");
        try {
            Location lastLocation = null;
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                lastKnownLocationTimerHandler.postDelayed(lastKnownLocationTimerRunnable, LOCATION_TIMEOUT_IN_MS);
                lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                lastKnownLocationTimerHandler.removeCallbacksAndMessages(null);
            }
            updateNetworkLocationByNetwork(lastLocation, bylastLocationOnly, originalIntent, attempts);
            return true;
        } catch (Exception e) {
            appendLog(getBaseContext(), TAG, "Exception during update of network location", e);
        }
        updateLocationInProcess = false;
        stopRefreshRotation("updateNetworkLocation", 3);
        sendMessageToWakeUpService(
                AppWakeUpManager.FALL_DOWN,
                AppWakeUpManager.SOURCE_LOCATION_UPDATE
        );
        return false;
    }

