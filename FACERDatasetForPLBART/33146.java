    private void createDetailedWeatherForecastForDayWithNegativeTemperatures() {
        Calendar forecastDay = Calendar.getInstance();
        forecastDay.set(Calendar.MINUTE, 0);
        forecastDay.set(Calendar.SECOND, 0);
        forecastDay.set(Calendar.MILLISECOND, 0);
        for (int i = 1; i < 24; i += 3) {
            double temp = -1.0 * i;
            forecastDay.set(Calendar.HOUR_OF_DAY, i);
            detailedWeatherForecasts.add(createDetailedWeatherForecast(forecastDay, temp));
        }
    }

