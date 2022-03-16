    protected void updateNetworkLocation(boolean byLastLocationOnly) {
        startRefreshRotation("updateNetworkLocation", 3);
        if (checkIfLocationUpdateServiceIsNotBound()) {
            locationUpdateServiceActions.add(
                    new LocationUpdateServiceActionsWithParams(
                            LocationUpdateService.LocationUpdateServiceActions.START_LOCATION_ONLY_UPDATE,
                            byLastLocationOnly));
        } else {
            locationUpdateService.updateNetworkLocation(
                    byLastLocationOnly,
                    null,
                    0);
        }
    }

