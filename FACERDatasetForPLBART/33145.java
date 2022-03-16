    private void createDetailedWeatherForecastForDay() {
        Calendar forecastDay = Calendar.getInstance();
        forecastDay.set(Calendar.YEAR, 2019);
        forecastDay.set(Calendar.MONTH, 11);
        forecastDay.set(Calendar.DAY_OF_MONTH, 28);
        forecastDay.set(Calendar.MINUTE, 0);
        forecastDay.set(Calendar.SECOND, 0);
        forecastDay.set(Calendar.MILLISECOND, 0);
        for (int dayCounter = 0; dayCounter < 5; dayCounter++) {
            for (int i = 1; i < 24; i += 3) {
                double temp = -1.0 * i;
                forecastDay.set(Calendar.HOUR_OF_DAY, i);
                detailedWeatherForecasts.add(createDetailedWeatherForecast(forecastDay, temp));
            }
            forecastDay.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

