    /**
     * Displays temperature, taking into account the scale preferred by the user.
     *
     * @param weatherInformation  various parameters describing weather
     * @param temperatureTextView view to display temperature
     */
    private void displayTemperatureText(WeatherInformation weatherInformation,
                                        TextView temperatureTextView) {
        String temperatureInfo;
        boolean isDayTemperatureProvided = weatherInformation.isDayTemperatureProvided();

        if (isDayTemperatureProvided) {
            TemperatureScale temperatureScale = getTemperatureScale();
            temperatureInfo = MiscMethods.formatDoubleValue(weatherInformation.getDayTemperature(
                    temperatureScale), 1) + res.getString(temperatureScale.getDisplayResourceId());
        } else {
            temperatureInfo = res.getString(R.string.data_not_available);
        }

        temperatureTextView.setText(temperatureInfo);
    }

