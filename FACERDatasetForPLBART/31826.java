    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu_refresh:
                if (connectionDetector.isNetworkAvailableAndConnected()) {
                    locationsDbHelper.updateLastUpdatedAndLocationSource(
                            currentLocation.getId(),
                            System.currentTimeMillis(),
                            getString(R.string.location_weather_update_status_update_started));
                    if ((currentLocation.getLatitude() == 0.0) && (currentLocation.getLongitude() == 0.0)) {
                        Toast.makeText(MainActivity.this,
                                R.string.location_not_initialized,
                                Toast.LENGTH_LONG).show();
                        return true;
                    }
                    currentLocation = locationsDbHelper.getLocationById(currentLocation.getId());
                    sendMessageToCurrentWeatherService(currentLocation, "MAIN");
                    setUpdateButtonState(true);
                } else {
                    Toast.makeText(MainActivity.this,
                            R.string.connection_not_found,
                            Toast.LENGTH_SHORT).show();
                    setUpdateButtonState(false);
                }
                return true;
            case R.id.main_menu_detect_location:
                requestLocation();
                return true;
            case R.id.main_menu_search_city:
                Intent intent = new Intent(MainActivity.this, LocationsActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

