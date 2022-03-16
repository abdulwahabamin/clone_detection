    protected boolean updateNetworkLocation() {
        startRefreshRotation("updateNetworkLocation", 3);
        if (locationUpdateService != null) {
            boolean result = locationUpdateService.updateNetworkLocation(false, null, 0);
            processLocationUpdate = false;
            return result;
        } else {
            locationUpdateServiceActions.add(
                    LocationUpdateService.LocationUpdateServiceActions.START_LOCATION_ONLY_UPDATE);
            bindLocationUpdateService();
            return false;
        }
    }

