    public static String getFormatedRainOrSnow(Context context, double value, Locale locale) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_RAIN_SNOW_UNITS, "mm");
        String format;
        if (unitsFromPreferences.contains("inches") ) {
            format = "%.3f";
        } else {
            format = "%.1f";
        }
        return String.format(locale, format, getRainOrSnow(context, value));
    }

