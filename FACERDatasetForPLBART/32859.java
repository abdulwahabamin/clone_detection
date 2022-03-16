    public static String getTemperatureUnit(Context context) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_TEMPERATURE_UNITS, "celsius");
        if (unitsFromPreferences.contains("fahrenheit") ) {
            return context.getString(R.string.temperature_unit_fahrenheit);
        } else {
            return context.getString(R.string.temperature_unit_celsius);
        }
    }

