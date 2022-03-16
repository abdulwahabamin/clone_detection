    /**
     * Saves the requested city and weather information type in the SharedPreferences, so they can
     * be retrieved later and a new request formed automatically.
     *
     * @param cityId          Open Weather Map ID for the requested city
     * @param weatherInfoType requested weather information type
     */
    private void saveWeatherInfoRequest(int cityId, WeatherInfoType weatherInfoType) {
        SharedPrefsHelper.putCityIdIntoSharedPrefs(this, cityId, false);
        SharedPrefsHelper.putLastWeatherInfoTypeIntoSharedPrefs(this, weatherInfoType);
    }

