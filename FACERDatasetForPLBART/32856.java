    public static String getDewPointWithUnit(Context context, Weather weather, Locale locale) {
        if (weather == null) {
            return null;
        }
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_TEMPERATURE_UNITS, "celsius");
        double humidityLogarithm = Math.log(weather.getHumidity() / 100.0) / Math.log(Math.E);
        double dewPointPart = humidityLogarithm + ((17.67 * weather.getTemperature())/(243.5 + weather.getTemperature()));
        double dewPoint = (243.5 * dewPointPart) / (17.67 - dewPointPart);
        if (unitsFromPreferences.contains("fahrenheit") ) {
            double fahrenheitValue = (dewPoint * 1.8f) + 32;
            return String.format(locale, "%.1f",
                    fahrenheitValue) + getTemperatureUnit(context);
        } else {
            return String.format(locale, "%.1f",
                    dewPoint) + getTemperatureUnit(context);
        }
    }

