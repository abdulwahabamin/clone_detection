    public static String getMeasuredTemperatureWithUnit(Context context, double weatherTemperature, String apparentSign, Locale locale) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_TEMPERATURE_UNITS, "celsius");
        if (unitsFromPreferences.contains("fahrenheit") ) {
            double fahrenheitValue = (weatherTemperature * 1.8f) + 32;
            return apparentSign + String.format(locale, "%d",
                    Math.round(fahrenheitValue)) + getTemperatureUnit(context);
        } else {
            return apparentSign + String.format(locale, "%d",
                    Math.round(weatherTemperature)) + getTemperatureUnit(context);
        }

    }

