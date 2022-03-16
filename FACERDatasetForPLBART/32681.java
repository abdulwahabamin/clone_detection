    public static WindWithUnit getWindWithUnit(Context context, float value, float direction, Locale locale) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_WIND_UNITS, "m_per_second");
        if (unitsFromPreferences.contains("km_per_hour") ) {
            double kmhValue = 3.6d * value;
            return new WindWithUnit(context, kmhValue, context.getString(R.string.wind_speed_kilometers), direction, locale);
        } else if (unitsFromPreferences.contains("miles_per_hour") ) {
            double mhValue = 2.2369d * value;
            return new WindWithUnit(context, mhValue, context.getString(R.string.wind_speed_miles), direction, locale);
        } else if (unitsFromPreferences.contains("knots") ) {
            double knotsValue = 1.9438445d * value;
            return new WindWithUnit(context, knotsValue, context.getString(R.string.wind_speed_knots), direction, locale);
        } else if (unitsFromPreferences.contains("beaufort") ) {
            double beaufortValue = mpsToBft(value);
            return new WindWithUnit(context, beaufortValue, context.getString(R.string.wind_speed_beaufort), direction, locale);
        } else {
            return new WindWithUnit(context, value, context.getString(R.string.wind_speed_meters), direction, locale);
        }
    }

