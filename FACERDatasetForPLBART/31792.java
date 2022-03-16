    private void deleteLocation(int position) {
        CurrentWeatherDbHelper currentWeatherDbHelper = CurrentWeatherDbHelper.getInstance(org.thosp.yourlocalweather.LocationsActivity.this);
        WeatherForecastDbHelper weatherForecastDbHelper = WeatherForecastDbHelper.getInstance(org.thosp.yourlocalweather.LocationsActivity.this);
        Location location = locationsAdapter.locations.get(position);
        int locatonOrder = location.getOrderId();
        currentWeatherDbHelper.deleteRecordByLocation(location);
        weatherForecastDbHelper.deleteRecordByLocation(location);
        locationsDbHelper.deleteRecordFromTable(location);

        if (locatonOrder == 1) {
            Intent intentToStartUpdate = new Intent("org.thosp.yourlocalweather.action.RESTART_ALARM_SERVICE");
            intentToStartUpdate.setPackage("org.thosp.yourlocalweather");
            this.startService(intentToStartUpdate);
        }

        locationsAdapter.locations.remove(position);
        locationsAdapter.notifyItemRemoved(position);
        locationsAdapter.notifyItemRangeChanged(position, locationsAdapter.getItemCount());
        List<Location> allLocations = locationsDbHelper.getAllRows();
        updateAddLocationButton(allLocations);
        locationsAdapter = new LocationsAdapter(allLocations);
        recyclerView.setAdapter(locationsAdapter);
        sendMessageToReconciliationDbService(true);
    }

