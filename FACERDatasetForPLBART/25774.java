    @Override
    public void updateItem(HoursForecastData data, int position) {
        WeatherData.HoursForecastEntity hoursForecastData = data.hoursForecastData;
        if (Check.isNull(hoursForecastData)) {
            return;
        }
        hour.setText(hoursForecastData.getTime().substring(11, 16));
        hourIcon.setImageResource(ResourceProvider.getIconId(hoursForecastData.getWeather()));
        hourTemp.setText(hoursForecastData.getTemp());
    }

