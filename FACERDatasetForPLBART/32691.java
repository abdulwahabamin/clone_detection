    public static String getWindUnit(Context context) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_WIND_UNITS, "m_per_second");
        if (unitsFromPreferences.contains("km_per_hour") ) {
            return context.getString(R.string.wind_speed_kilometers);
        } else if (unitsFromPreferences.contains("miles_per_hour") ) {
            return context.getString(R.string.wind_speed_miles);
        } else if (unitsFromPreferences.contains("knots") ) {
            return context.getString(R.string.wind_speed_knots);
        } else if (unitsFromPreferences.contains("beaufort") ) {
            return context.getString(R.string.wind_speed_beaufort);
        } else {
            return context.getString(R.string.wind_speed_meters);
        }
    }

