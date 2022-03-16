    private org.thosp.yourlocalweather.model.Location processUpdateOfLocation(Location location, Address address) {
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());

        String updateDetailLevel = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString(
                Constants.KEY_PREF_UPDATE_DETAIL, "preference_display_update_nothing");

        org.thosp.yourlocalweather.model.Location currentLocation = locationsDbHelper.getLocationByOrderId(0);

        String currentLocationSource = currentLocation.getLocationSource();
        if ("gps".equals(location.getProvider())) {
            currentLocationSource = getString(R.string.location_weather_update_status_location_from_gps);
        } else if (updateDetailLevel.equals("preference_display_update_location_source")) {
            StringBuilder networkSourceBuilder = new StringBuilder();
            networkSourceBuilder.append(getString(R.string.location_weather_update_status_location_from_network));
            boolean additionalSourceSetted = false;

            if ((location.getExtras() != null) && (location.getExtras().containsKey("source"))) {
                String networkSource = location.getExtras().getString("source");
                if (networkSource != null) {
                    if (networkSource.contains("cells")) {
                        networkSourceBuilder.append(getString(R.string.location_weather_update_status_location_from_network_cells));
                        additionalSourceSetted = true;
                    }
                    if (networkSource.contains("wifis")) {
                        networkSourceBuilder.append(getString(R.string.location_weather_update_status_location_from_network_wifis));
                        additionalSourceSetted = true;
                    }
                }
            }
            if (!additionalSourceSetted) {
                networkSourceBuilder.append(location.getProvider().substring(0, 1));
            }
            currentLocationSource = networkSourceBuilder.toString();
            appendLog(getBaseContext(), TAG, "send update source to ", currentLocationSource);
        } else if (getString(R.string.location_weather_update_status_update_started).equals(currentLocationSource)) {
            currentLocationSource = getString(R.string.location_weather_update_status_location_from_network);
        }
        currentLocation = locationsDbHelper.getLocationById(currentLocation.getId());
        checkDistanceAndRemoveForecastIfTheNewLocationIsFarAway(location, currentLocation);
        locationsDbHelper.updateAutoLocationGeoLocation(location.getLatitude(), location.getLongitude(), currentLocationSource, location.getAccuracy(), getLocationTimeInMilis(location));
        appendLog(getBaseContext(), TAG, "put new location from location update service, latitude=", location.getLatitude(), ", longitude=", location.getLongitude());
        if (address != null) {
            locationsDbHelper.updateAutoLocationAddress(getBaseContext(), PreferenceUtil.getLanguage(getBaseContext()), address);
        } else {
            String geocoder = AppPreference.getLocationGeocoderSource(this);
            boolean resolveAddressByOS = !"location_geocoder_local".equals(geocoder);
            locationsDbHelper.setNoLocationFound();
            Utils.getAndWriteAddressFromGeocoder(new Geocoder(this, new Locale(PreferenceUtil.getLanguage(this))),
                    address,
                    location.getLatitude(),
                    location.getLongitude(),
                    resolveAddressByOS,
                    this);
        }
        return currentLocation;
    }

