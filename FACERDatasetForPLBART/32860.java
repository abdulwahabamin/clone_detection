    public static double getTemperatureInPreferredUnit(Context context, double inputValue) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_TEMPERATURE_UNITS, "celsius");
        if (unitsFromPreferences.contains("fahrenheit") ) {
            return (inputValue * 1.8d) + 32;
        } else {
            return inputValue;
        }
    }

