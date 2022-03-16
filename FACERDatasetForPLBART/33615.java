    /**
     * Obtains a text to be displayed in the extraTemperaturesTextView.
     *
     * @param cityDailyWeatherForecast Java object, corresponding to the Open Weather Map JSON
     *                                 weather forecast data for one day
     * @return the night, morning, and evening temperatures
     */
    private String getExtraTemperatureText(CityDailyWeatherForecast cityDailyWeatherForecast) {
        Temperature temperature = cityDailyWeatherForecast.getTemperature();
        TemperatureScale temperatureScale = weatherInformationDisplayer.getTemperatureScale();
        String temperatureScaleDegree = getResources().getString(
                temperatureScale.getDisplayResourceId());
        String temperatureInfo = MiscMethods.formatDoubleValue(temperature
                .getNightTemperature(temperatureScale), 1) + temperatureScaleDegree;
        temperatureInfo += "\n" + MiscMethods.formatDoubleValue(temperature
                .getMorningTemperature(temperatureScale), 1) + temperatureScaleDegree;
        temperatureInfo += "\n" + MiscMethods.formatDoubleValue(temperature
                .getEveningTemperature(temperatureScale), 1) + temperatureScaleDegree;
        return temperatureInfo;
    }

