    private void loadLastFoundCity() {
        if (mCites.isEmpty()) {
            String lastCity = mCityPref.getString(APP_SETTINGS_CITY, "London");
            String lastCountry = mCityPref.getString(APP_SETTINGS_COUNTRY_CODE, "UK");
            String lastLat = mCityPref.getString(APP_SETTINGS_LATITUDE, "51.51");
            String lastLon = mCityPref.getString(APP_SETTINGS_LONGITUDE, "-0.13");
            CitySearch city = new CitySearch(lastCity, lastCountry, lastLat, lastLon);
            mCites.add(city);
        }
    }

