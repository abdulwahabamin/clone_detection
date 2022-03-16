    private void switchToNextLocationWhenCurrentIsAutoAndIsDisabled() {
        if (currentLocation == null) {
            currentLocation = locationsDbHelper.getLocationByOrderId(0);
        }
        if ((currentLocation.getOrderId() == 0) && !currentLocation.isEnabled() && (locationsDbHelper.getAllRows().size() > 1)) {
            currentLocation = locationsDbHelper.getLocationByOrderId(1);
        }
    }

