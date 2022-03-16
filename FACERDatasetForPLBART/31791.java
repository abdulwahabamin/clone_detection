    private void disableEnableLocation() {
        Location location = locationsAdapter.locations.get(0);
        locationsDbHelper.updateEnabled(location.getId(), !location.isEnabled());
        Intent intentToStartUpdate = new Intent("org.thosp.yourlocalweather.action.RESTART_ALARM_SERVICE");
        intentToStartUpdate.setPackage("org.thosp.yourlocalweather");
        startService(intentToStartUpdate);
        List<Location> allLocations = locationsDbHelper.getAllRows();
        updateAddLocationButton(allLocations);
        locationsAdapter = new LocationsAdapter(allLocations);
        recyclerView.setAdapter(locationsAdapter);
        sendMessageToReconciliationDbService(true);
    }

