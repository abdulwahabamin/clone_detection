    public static boolean noPermissionGranted(Context context) {
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(context);
        Location autoLocation = locationsDbHelper.getLocationByOrderId(0);
        if (!autoLocation.isEnabled()) {
            appendLog(context, TAG_CHECK_PERMISSIONS_AND_SETTINGS,
                    "locationUpdateStrategy is set to update_location_none, return false");
            return false;
        }
        List<String> permissions = getAllPermissions(context);
        if ((permissions != null) && (permissions.size() > 0)) {
            return true;
        }
        return false;
    }

