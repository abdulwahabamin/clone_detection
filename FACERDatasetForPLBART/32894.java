    public static String getCityAndCountry(Context context, int locationOrderId) {
        final LocationsDbHelper locationDbHelper = LocationsDbHelper.getInstance(context);
        Location foundLocation = locationDbHelper.getLocationByOrderId(locationOrderId);
        if (foundLocation == null) {
            return context.getString(R.string.location_not_found);
        }
        if ("E".equals(foundLocation.getLocationSource())) {
            if (ApiKeys.isDefaultOpenweatherApiKey(context)) {
                return context.getString(R.string.subscription_expired);
            } else {
                return context.getString(R.string.subscription_is_wrong);
            }
        }
        if (!foundLocation.isAddressFound()) {
            return context.getString(R.string.location_not_found);
        }

        return getCityAndCountryFromAddress(foundLocation.getAddress());
    }

