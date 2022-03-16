    public static String getForecastedApparentTemperatureWithUnit(
            Context context,
            double latitude,
            DetailedWeatherForecast weather,
            Locale locale) {

        if (weather == null) {
            return null;
        }
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_TEMPERATURE_UNITS, "celsius");
        String apparentSign = "";
        double value = TemperatureUtil.getApparentTemperatureWithSolarIrradiation(
                    weather.getTemperature(),
                    weather.getHumidity(),
                    weather.getWindSpeed(),
                    weather.getCloudiness(),
                    latitude,
                    weather.getDateTime()
                );
        if (value > 0) {
            apparentSign += "+";
        }
        if (unitsFromPreferences.contains("fahrenheit") ) {
            double fahrenheitValue = (value * 1.8f) + 32;
            return apparentSign + String.format(locale, "%d",
                    Math.round(fahrenheitValue)) + getTemperatureUnit(context);
        } else {
            return apparentSign + String.format(locale, "%d",
                    Math.round(value)) + getTemperatureUnit(context);
        }
    }

