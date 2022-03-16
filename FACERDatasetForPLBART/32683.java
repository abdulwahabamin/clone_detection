    public static int getGraphFormatterForRainOrSnow(Context context) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_RAIN_SNOW_UNITS, "mm");
        if (unitsFromPreferences.contains("inches") ) {
            return 3;
        } else {
            return 2;
        }
    }

