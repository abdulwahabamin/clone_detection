    public static int getAvailableLocations(Context context) {
        if (isDefaultOpenweatherApiKey(context)) {
            return DEFAULT_AVAILABLE_LOCATIONS;
        } else {
            return MAX_AVAILABLE_LOCATIONS;
        }
    }

