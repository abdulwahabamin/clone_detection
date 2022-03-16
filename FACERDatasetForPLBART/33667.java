    /**
     * Displays humidity.
     *
     * @param weatherInformation various parameters describing the weather
     * @param humidityTextView   view to display humidity
     */
    private void displayHumidity(WeatherInformation weatherInformation, TextView humidityTextView) {
        String humidityInfo = res.getString(R.string.weather_info_humidity) + SEPARATOR;
        boolean isHumidityProvided = weatherInformation.isHumidityProvided();

        if (isHumidityProvided) {
            long humidity = Math.round(weatherInformation.getHumidity());
            humidityInfo += humidity + PERCENT_SIGN;
        } else {
            humidityInfo += res.getString(R.string.data_not_available);
        }

        humidityTextView.setText(humidityInfo);
    }

