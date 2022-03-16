    public static String getCityFromAddress(Address address) {
        if (address == null) {
            return "";
        }
        String geoCity;
        if ((address.getLocality() != null) && !"".equals(address.getLocality())) {
            geoCity = address.getLocality();
        } else {
            geoCity = address.getSubAdminArea();
        }
        if (geoCity == null) {
            geoCity = "";
        }
        return geoCity;
    }

