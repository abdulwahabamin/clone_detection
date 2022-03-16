    public static void setCurrentLocationId(Context context, Location currentLocation) {
        Long currentLocationId = null;
        if (currentLocation != null) {
            currentLocationId = currentLocation.getId();
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong(
                Constants.CURRENT_LOCATION_ID, currentLocationId).apply();
    }

