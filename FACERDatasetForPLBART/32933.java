    public WindWithUnit(Context context, double windDirection, Locale locale) {
        this.windDirection = windDirection;
        this.context = context;
        this.pressureLocale = locale;
        directionTypeFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_WIND_DIRECTION, "abbreviation");
    }

