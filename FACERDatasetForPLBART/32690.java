    public static double getWind(Context context, double windSpeed) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_WIND_UNITS, "m_per_second");
        if (unitsFromPreferences.contains("km_per_hour") ) {
            return 3.6d * windSpeed;
        } else if (unitsFromPreferences.contains("miles_per_hour") ) {
            return 2.2369d * windSpeed;
        } else if (unitsFromPreferences.contains("knots") ) {
            return 1.9438445d * windSpeed;
        } else if (unitsFromPreferences.contains("beaufort") ) {
            return mpsToBft(windSpeed);
        } else {
            return windSpeed;
        }
    }

