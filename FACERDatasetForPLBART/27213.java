    public LocationEvent parseLocation(Location location) {
        String country = "";
        String region= "";
        String city= "";
        if (location == null) {
            return new LocationEvent(country, region, city);
        }
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses  = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (addresses != null && addresses.size() > 0) {
                if (addresses.get(0).getLocality() != null) {
                    city = addresses.get(0).getLocality();
                    country = addresses.get(0).getCountryName();
                    region = addresses.get(0).getAdminArea();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LocationEvent(country, region, city);
    }

