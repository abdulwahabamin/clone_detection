    public static double getRainOrSnow(Context context, double value) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_RAIN_SNOW_UNITS, "mm");
        if (unitsFromPreferences.contains("inches") ) {
            return 0.03937007874d * value;
        } else {
            return value;
        }
    }

