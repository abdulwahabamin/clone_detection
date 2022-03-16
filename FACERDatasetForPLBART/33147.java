    private DetailedWeatherForecast createDetailedWeatherForecast(Calendar forecastDay, double temp) {
        DetailedWeatherForecast detailedWeatherForecast = new DetailedWeatherForecast();
        detailedWeatherForecast.setDateTime(forecastDay.getTimeInMillis()/1000);
        detailedWeatherForecast.setTemperature(temp);
        detailedWeatherForecast.addWeatherCondition(800, "01n", "clear sky");

        return detailedWeatherForecast;
    }

