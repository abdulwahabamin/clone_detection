    public static String getLocationForSharingFromAddress(Address address) {
        if (address == null) {
            return "";
        }
        String geoCity = getCityFromAddress(address);
        String geoDistrictOfCity = address.getSubLocality();
        if ((geoDistrictOfCity == null) || "".equals(geoDistrictOfCity) || geoCity.equalsIgnoreCase(geoDistrictOfCity)) {
            return geoCity;
        }
        return (("".equals(geoCity))?"":(geoCity + " - ")) + geoDistrictOfCity;
    }

