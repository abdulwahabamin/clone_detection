    public static int getRainOrSnowUnit(Context context) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_RAIN_SNOW_UNITS, "mm");
        if (unitsFromPreferences.contains("inches") ) {
            return R.string.inches_label;
        } else {
            return R.string.millimetre_label;
        }
    }

