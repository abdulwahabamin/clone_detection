    /**
     * Displays pressure.
     *
     * @param weatherInformation various parameters describing the weather
     * @param pressureTextView   view to display atmospheric pressure
     */
    private void displayAtmosphericPressureText(WeatherInformation weatherInformation,
                                                TextView pressureTextView) {
        String pressureInfo = res.getString(R.string.weather_info_atmospheric_pressure) + SEPARATOR;
        boolean isPressureProvided = weatherInformation.isPressureProvided();

        if (isPressureProvided) {
            long pressure = Math.round(weatherInformation.getPressure());
            pressureInfo += pressure + " " + HECTOPASCAL;
        } else {
            pressureInfo += res.getString(R.string.data_not_available);
        }

        pressureTextView.setText(pressureInfo);
    }

