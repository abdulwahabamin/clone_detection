    private void setCity(CitySearch city) {
        SharedPreferences.Editor editor = mCityPref.edit();
        editor.putString(APP_SETTINGS_CITY, city.getCityName());
        editor.putString(APP_SETTINGS_COUNTRY_CODE, city.getCountryCode());
        editor.putString(APP_SETTINGS_LATITUDE, city.getLatitude());
        editor.putString(APP_SETTINGS_LONGITUDE, city.getLongitude());
        editor.apply();
    }

