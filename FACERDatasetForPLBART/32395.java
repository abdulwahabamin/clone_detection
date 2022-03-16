    protected void reportNewLocation(Location location, Address address) {
        if (locationUpdateService != null) {
            locationUpdateService.onLocationChanged(
                    location,
                    address);
        } else {
            locationUpdateServiceActions.add(
                    new LocationAndAddressToUpdate(
                            location,
                            address));
            bindLocationUpdateService();
        }
    }

