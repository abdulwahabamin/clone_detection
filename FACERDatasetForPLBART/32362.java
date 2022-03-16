    public void processLocationAndWeatherUpdate(Intent intent) {
        boolean isGPSEnabled = AppPreference.isGpsEnabledByPreferences(this) &&
                locationManager.getAllProviders().contains(LocationManager.GPS_PROVIDER)
                && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetworkEnabled = locationManager.getAllProviders().contains(LocationManager.NETWORK_PROVIDER)
                && locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        appendLog(getBaseContext(), TAG, "startLocationAndWeatherUpdate:isGPSEnabled=",
                                        isGPSEnabled, ", isNetworkEnabled=", isNetworkEnabled);

        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());
        org.thosp.yourlocalweather.model.Location currentLocation = locationsDbHelper.getLocationByOrderId(0);
        locationsDbHelper.updateLocationSource(currentLocation.getId(), getString(R.string.location_weather_update_status_update_started));

        boolean isUpdateOfLocationEnabled = AppPreference.isUpdateLocationEnabled(this, currentLocation);
        appendLog(this, TAG,
                "START_LOCATION_AND_WEATHER_UPDATE, isUpdateOfLocationEnabled=",
                isUpdateOfLocationEnabled,
                ", isGPSEnabled=",
                isGPSEnabled,
                ", isNetworkEnabled=",
                isNetworkEnabled);
        String geocoder = AppPreference.getLocationGeocoderSource(this);
        if (isUpdateOfLocationEnabled && (isGPSEnabled || isNetworkEnabled || !"location_geocoder_system".equals(geocoder))) {
            appendLog(getBaseContext(), TAG, "Widget calls to update location, geocoder = ", geocoder);
            sendMessageToWakeUpService(
                    AppWakeUpManager.WAKE_UP,
                    AppWakeUpManager.SOURCE_LOCATION_UPDATE
            );
            if ("location_geocoder_local".equals(geocoder)) {
                updateNetworkLocation(false, intent, 0, forceUpdate);
            } else {
                detectLocation();
            }
        } else {
            appendLog(getBaseContext(), TAG, "startLocationAndWeatherUpdate:requestWeatherCheck");
            requestWeatherCheck(currentLocation.getId(), updateSource, AppWakeUpManager.SOURCE_CURRENT_WEATHER, forceUpdate);
        }
    }

