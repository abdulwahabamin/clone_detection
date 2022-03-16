    public static void getAndWriteAddressFromGeocoder(Geocoder geocoder,
                                                      Address address,
                                                      double latitude,
                                                      double longitude,
                                                      boolean resolveAddressByOS,
                                                      Context context) {
        try {
            final LocationsDbHelper locationDbHelper = LocationsDbHelper.getInstance(context);
            if (resolveAddressByOS) {
                List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
                if((addresses != null) && (addresses.size() > 0)) {
                    address = addresses.get(0);
                }
            }
            if(address != null) {
                locationDbHelper.updateAutoLocationAddress(context, PreferenceUtil.getLanguage(context), address);
            } else {
                locationDbHelper.setNoLocationFound();
            }
        } catch (IOException | NumberFormatException ex) {
            Log.e(Utils.class.getName(), "Unable to get address from latitude and longitude", ex);
        }
    }

