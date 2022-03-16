    private void saveInitialPreferences() {
        SharedPreferences.Editor preferences = PreferenceManager.getDefaultSharedPreferences(this).edit();

        boolean gpsEnabled = true;
        boolean locationUpdateEnabled = true;
        switch (selectedUpdateLocationStrategy) {
            case 0: locationUpdateEnabled = false; gpsEnabled = false; break;
            case 1: locationUpdateEnabled = true; gpsEnabled = true; break;
            case 2: locationUpdateEnabled = true; gpsEnabled = false; break;
        }
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(this);
        Location autoLocation = locationsDbHelper.getLocationByOrderId(0);
        locationsDbHelper.updateEnabled(autoLocation.getId(), locationUpdateEnabled);
        preferences.putBoolean(Constants.KEY_PREF_LOCATION_GPS_ENABLED, gpsEnabled);

        String selectedWakeupStrategyStrategyString = "nowakeup";
        switch (selectedWakeupStrategyStrategy) {
            case 0: selectedWakeupStrategyStrategyString = "nowakeup"; break;
            case 1: selectedWakeupStrategyStrategyString = "wakeuppartial"; break;
            case 2: selectedWakeupStrategyStrategyString = "wakeupfull"; break;
        }
        preferences.putString(Constants.KEY_WAKE_UP_STRATEGY, selectedWakeupStrategyStrategyString);

        String selectedLocationAndAddressSourceStrategyString = "location_geocoder_local";
        switch (selectedLocationAndAddressSourceStrategy) {
            case 0: selectedLocationAndAddressSourceStrategyString = "location_geocoder_local"; break;
            case 1: selectedLocationAndAddressSourceStrategyString = "location_geocoder_system"; break;
        }
        preferences.putString(Constants.KEY_PREF_LOCATION_GEOCODER_SOURCE, selectedLocationAndAddressSourceStrategyString);

        boolean selectedCacheLocationStrategyBoolean = false;
        switch (selectedCacheLocationStrategy) {
            case 0: selectedCacheLocationStrategyBoolean = false; break;
            case 1: selectedCacheLocationStrategyBoolean = true; break;
        }
        preferences.putBoolean(Constants.APP_SETTINGS_LOCATION_CACHE_ENABLED, selectedCacheLocationStrategyBoolean);

        preferences.putInt(Constants.APP_INITIAL_GUIDE_VERSION, 4);
        preferences.apply();
    }

