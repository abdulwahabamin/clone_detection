    public String getWindSpeed(int decimalPlaces) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_WIND_UNITS, "m_per_second");
        if (unitsFromPreferences.contains("beaufort")) {
            decimalPlaces = 0;
        }
        return String.format(pressureLocale,
                "%." + decimalPlaces + "f", windSpeed);
    }

