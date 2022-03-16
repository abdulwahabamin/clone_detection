    private void updateNetworkLocation() {
        Intent startLocationUpdateIntent = new Intent("android.intent.action.START_LOCATION_AND_WEATHER_UPDATE");
        startLocationUpdateIntent.setPackage("org.thosp.yourlocalweather");
        startLocationUpdateIntent.putExtra("updateSource", "MAIN");
        startLocationUpdateIntent.putExtra("locationId", currentLocation.getId());
        storedContext.startService(startLocationUpdateIntent);
    }

