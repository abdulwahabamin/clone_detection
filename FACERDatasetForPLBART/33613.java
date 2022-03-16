    @Override
    protected void displayExtraInfo(WeatherInformation weatherInformation) {
        CityDailyWeatherForecast cityDailyWeatherForecast =
                (CityDailyWeatherForecast) weatherInformation;

        String extraInfoText = getExtraInfoText(cityDailyWeatherForecast);
        extraInfoTextView.setText(extraInfoText);

        String temperatureInfo = getExtraTemperatureText(cityDailyWeatherForecast);
        extraTemperaturesTextView.setText(temperatureInfo);
    }

