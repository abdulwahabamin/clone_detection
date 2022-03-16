    /**
     * Starts an {@link android.os.AsyncTask} to obtain the requested JSON weather data.
     *
     * @param cityId          an Open Weather Map city ID
     * @param weatherInfoType a type of the requested weather data
     */
    public void retrieveWeatherInfoJsonString(int cityId, WeatherInfoType weatherInfoType) {
        this.cityId = cityId;
        this.weatherInfoType = weatherInfoType;

        URL openWeatherMapUrl = weatherInfoType.getOpenWeatherMapUrl(parentActivity, cityId);
        retrieveWeatherInformationJsonStringTask =
                new RetrieveWeatherInformationJsonStringTask();
        retrieveWeatherInformationJsonStringTask.setContext(parentActivity);
        retrieveWeatherInformationJsonStringTask.execute(openWeatherMapUrl);
    }

