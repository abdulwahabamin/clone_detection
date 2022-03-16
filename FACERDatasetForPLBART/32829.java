    public static Location getLocationForNotification(Context context) {
        final LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(context);
        Location currentLocation = locationsDbHelper.getLocationByOrderId(0);
        if (!currentLocation.isEnabled()) {
            currentLocation = locationsDbHelper.getLocationByOrderId(1);
        }
        return currentLocation;
    }

