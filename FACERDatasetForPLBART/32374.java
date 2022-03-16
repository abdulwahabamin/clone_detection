    private void startLocationUpdate(Location inputLocation) {
        appendLog(getBaseContext(), TAG, "startLocationUpdate");
        if (networkLocationProvider == null) {
            networkLocationProviderActions.add(new NetworkLocationProviderActionData(
                    NetworkLocationProvider.NetworkLocationProviderActions.START_LOCATION_UPDATE,
                    inputLocation));
            return;
        }
        networkLocationProvider.startLocationUpdate(inputLocation);
    }

