    /**
     * Repeats the last weather data request, i.e. retrieves the weather information using
     * parameters (city and information type) used for the last attempt to obtain weather
     * information.
     */
    public void retrieveLastRequestedWeatherInfo() {
        int lastCityId = SharedPrefsHelper.getCityIdFromSharedPrefs(parentActivity);
        if (lastCityId != CityTable.CITY_ID_DOES_NOT_EXIST) {
            WeatherInfoType lastWeatherInfoType = SharedPrefsHelper
                    .getLastWeatherInfoTypeFromSharedPrefs(parentActivity);
            retrieveWeatherInfoJsonString(lastCityId, lastWeatherInfoType);
        }
    }

