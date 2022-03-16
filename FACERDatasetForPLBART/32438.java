    private List<Address> retrieveLocationFromCache(Context context, ReverseGeocodingCacheDbHelper mDbHelper, double latitude, double longitude, String locale) {
        boolean useCache = PreferenceManager.getDefaultSharedPreferences(context).getBoolean(Constants.APP_SETTINGS_LOCATION_CACHE_ENABLED, false);

        if (!useCache) {
            return null;
        }

        Address addressFromCache = getResultFromCache(mDbHelper, latitude, longitude, locale);
        appendLog(context, TAG, "address retrieved from cache:", addressFromCache);
        if (addressFromCache == null) {
            return null;
        }
        List<Address> addresses = new ArrayList<>();
        addresses.add(addressFromCache);
        return addresses;
    }

