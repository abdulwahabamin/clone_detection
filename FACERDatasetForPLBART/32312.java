        @Override
        public void run() {
                        
            if (!gettingWeatherStarted) {
                return;
            }
            final LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());

            WeatherRequestDataHolder updateRequest = currentWeatherUpdateMessages.peek();
            Location currentLocation = locationsDbHelper.getLocationById(updateRequest.getLocationId());
            if (currentLocation == null) {
                appendLog(getBaseContext(), TAG, "timerRunnable, currentLocation is null");
                return;
            }

            String originalUpdateState = currentLocation.getLocationSource();
            if (originalUpdateState == null) {
                originalUpdateState = getString(R.string.location_weather_update_status_update_started);
            }
            appendLog(getBaseContext(), TAG, "originalUpdateState:", originalUpdateState);
            String newUpdateState = originalUpdateState;
            if (originalUpdateState.contains(getString(R.string.location_weather_update_status_location_from_network))) {
                appendLog(getBaseContext(), TAG, "originalUpdateState contains N");
                newUpdateState = originalUpdateState.replace(getString(R.string.location_weather_update_status_location_from_network), getString(R.string.location_weather_update_status_location_only));
            } else if (originalUpdateState.contains(getString(R.string.location_weather_update_status_location_from_gps))) {
                newUpdateState = getString(R.string.location_weather_update_status_location_only);
            }
            appendLog(getBaseContext(), TAG, "currentLocation:",
                    currentLocation,
                    ", newUpdateState:",
                    newUpdateState);
            if (currentLocation != null) {
                locationsDbHelper.updateLocationSource(currentLocation.getId(), newUpdateState);
            }
            sendResult(ACTION_WEATHER_UPDATE_FAIL, getBaseContext());
        }

