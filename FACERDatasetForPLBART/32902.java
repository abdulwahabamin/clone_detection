    public static String getCityAndCountryFromAddress(Address address) {
        if (address == null) {
            return "";
        }
        String geoCity = getCityFromAddress(address);
        String geoCountryDistrict = null;
        if(address.getAdminArea() != null) {
            geoCountryDistrict = address.getAdminArea();
        }
        String geoDistrictOfCity = address.getSubLocality();
        String geoCountryName = address.getCountryName();
        if ((geoDistrictOfCity == null) || "".equals(geoDistrictOfCity) || geoCity.equalsIgnoreCase(geoDistrictOfCity)) {
            if ((geoCountryDistrict == null) || "".equals(geoCountryDistrict) || geoCity.equals(geoCountryDistrict)) {
                return formatLocalityToTwoLines((("".equals(geoCity))?"":(geoCity)) + (("".equals(geoCountryName))?"":(", " + geoCountryName)));
            }
            return formatLocalityToTwoLines((("".equals(geoCity))?"":(geoCity + ", ")) + geoCountryDistrict + (("".equals(geoCountryName))?"":(", " + geoCountryName)));
        }
        return formatLocalityToTwoLines((("".equals(geoCity))?"":(geoCity + " - ")) + geoDistrictOfCity + (("".equals(geoCountryName))?"":(", " + geoCountryName)));
    }

