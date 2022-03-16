    protected void reportCanceledRequestForNewLocation() {
        if (locationUpdateService != null) {
            locationUpdateService.onLocationChangedCanceled();
        } else {
            locationUpdateServiceActions.add(
                    new LocationAndAddressToUpdate(true));
            bindLocationUpdateService();
        }
    }

