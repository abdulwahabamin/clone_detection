    public static boolean isGpsEnabledByPreferences(Context context) {
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(context);
        Location locationAuto = locationsDbHelper.getLocationByOrderId(0);
        return locationAuto.isEnabled() && PreferenceManager.getDefaultSharedPreferences(context).getBoolean(
                Constants.KEY_PREF_LOCATION_GPS_ENABLED, true);
    }

