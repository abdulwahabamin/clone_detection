    /**
     * Makes note in the SharedPreferences if the city to be deleted is also the
     * last city to be queried for weather information (so the next time an
     * automatic weather information request is made, it won't be necessary to
     * go to the database to check if the city still exists).
     *
     * @param cityId OpenWeatherMap city ID
     */
    private void updateLastRequestedCityInfo(int cityId) {
        int lastCityId = SharedPrefsHelper.getCityIdFromSharedPrefs(this);
        if (cityId == lastCityId) {
            SharedPrefsHelper.putCityIdIntoSharedPrefs(this, CityTable.CITY_ID_DOES_NOT_EXIST,
                    false);
        }
    }

